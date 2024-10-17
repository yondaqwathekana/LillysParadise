package za.ac.cput.service.security;

import jakarta.mail.MessagingException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;
import za.ac.cput.dto.LoginUserDto;
import za.ac.cput.dto.RegisterUserDto;
import za.ac.cput.dto.VerifyUserDto;
import za.ac.cput.repository.RoleRepository;
import za.ac.cput.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, EmailService emailService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.emailService = emailService;
    }

    // Admin signing in with verification check if not enabled
    public Admin adminSignIn(LoginUserDto input) {
        System.out.println("Login attempt for Admin: " + input.getEmail());

        User user = userRepository.findByEmail(input.getEmail()).orElseThrow(() -> new RuntimeException("Admin not found."));
        if (user instanceof Admin) {
            authenticateUser(input.getEmail(), input.getPassword());
            if (!user.isEnabled()) {
                user.setVerificationCode(generateVerificationCode());
                user.setCodeExpiry(LocalDateTime.now().plusMinutes(15));
                userRepository.save(user);
                sendVerificationEmail(user, "Admin");
                throw new RuntimeException("Admin account not verified. Verification email sent.");
            }
            return (Admin) user;
        } else {
            throw new RuntimeException("User is not an Admin.");
        }
    }

    private void setUpNewUser(User user, Set<Role> roles) {
        user.setRoles(roles);
        user.setVerificationCode(generateVerificationCode());
        user.setCodeExpiry(LocalDateTime.now().plusMinutes(15));
        user.setEnabled(false);  // Users are not enabled until they verify
    }

    public Guest guestSignUp(RegisterUserDto input) {
        Guest guest = new Guest(input.getName(), input.getContact(), input.getEmail(), passwordEncoder.encode(input.getPassword()));
        Set<Role> roles = Set.of(roleRepository.findByName("Guest").orElseGet(() -> roleRepository.save(new Role("Guest"))));
        setUpNewUser(guest, roles);
        sendVerificationEmail(guest, "Guest");

        return userRepository.save(guest);
    }
    public Guest guestSignIn(LoginUserDto input) {
        System.out.println("Login attempt for Guest: " + input.getEmail());
        User user = userRepository.findByEmail(input.getEmail()).orElseThrow(() -> new RuntimeException("Guest not found."));
        if (user instanceof Guest) {
            if (!user.isEnabled()) {
                throw new RuntimeException("Guest account not verified. Please verify your account before logging in.");
            }
            authenticateUser(input.getEmail(), input.getPassword());
            return (Guest) user;
        } else {
            throw new RuntimeException("User is not a Guest.");
        }
    }
    private void authenticateUser(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    }

    public void verifyAdmin(VerifyUserDto input) {
        User user = userRepository.findByEmail(input.getEmail()).orElseThrow(() -> new RuntimeException("Admin not found."));
        if (user.getVerificationCode().equals(input.getVerificationCode())) {
            user.setEnabled(true);
            user.setVerificationCode(null);
            user.setCodeExpiry(null);
            userRepository.save(user);
            System.out.println("Admin account verified.");
        } else {
            throw new RuntimeException("Invalid verification code.");
        }
    }

    public void verifyGuest(VerifyUserDto input) {
        User user = userRepository.findByEmail(input.getEmail()).orElseThrow(() -> new RuntimeException("Guest not found."));

        if (user.getVerificationCode().equals(input.getVerificationCode())) {
            user.setEnabled(true);
            user.setVerificationCode(null);
            user.setCodeExpiry(null);
            userRepository.save(user);
            System.out.println("Guest account verified.");
        } else {
            throw new RuntimeException("Invalid verification code.");
        }
    }

    private void sendVerificationEmail(User user, String userType) {
        String subject = userType + " account verification";
        String verificationCode = "Code: " + user.getVerificationCode();
        String htmlMessage = generateHtmlMessage(verificationCode);
        try {
            emailService.sendVerificationEmail(user.getEmail(), subject, htmlMessage);
        } catch (MessagingException exception) {
            throw new RuntimeException(userType + " verification email not sent.");
        }
    }

    private String generateHtmlMessage(String verificationCode) {
        return "<html><body style=\"font-family: 'Arial', sans-serif; margin: 0; padding: 0; background-color: #f5f5f5;\">"
                + "<div style=\"max-width: 600px; margin: 20px auto; padding: 20px; background-color: #ffffff; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1);\">"
                + "<h1 style=\"color: #4CAF50; text-align: center;\">Welcome to Lily's Paradise BNB!</h1>"
                + "<p style=\"font-size: 16px;\">Hello!</p>"
                + "<p style=\"font-size: 16px;\">Thank you for signing up. We're excited to have you at Lily's Paradise BNB. To complete your registration, please verify your account by entering the code below:</p>"
                + "<div style=\"background-color: #f1f1f1; padding: 15px; border-radius: 5px; text-align: center; margin: 20px 0;\">"
                + "<h3 style=\"color: #333;\">Your Verification Code:</h3>"
                + "<p style=\"font-size: 24px; font-weight: bold; color: #007bff;\">" + verificationCode + "</p>"
                + "</div>"
                + "<p style=\"font-size: 16px;\">If you didn't create an account, please ignore this email.</p>"
                + "<p style=\"font-size: 16px;\">We can't wait to host you!</p>"
                + "<footer style=\"margin-top: 20px; text-align: center; font-size: 14px; color: #888;\">"
                + "<p>Thank you,</p>"
                + "<p>The Lily's Paradise BNB Team</p>"
                + "<p><a href=\"https://localhost:8081\" style=\"color: #4CAF50; text-decoration: none;\">Visit our website</a></p>"
                + "</footer>"
                + "</div>"
                + "</body></html>";
    }


    private String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000;
        return String.valueOf(code);
    }
}
