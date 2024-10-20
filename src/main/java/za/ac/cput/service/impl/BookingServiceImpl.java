package za.ac.cput.service.impl;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Room;
import za.ac.cput.repository.BookingRepository;
import za.ac.cput.service.BookingService;
import za.ac.cput.service.security.EmailService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final EmailService emailService;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, EmailService emailService){
        this.bookingRepository = bookingRepository;
        this.emailService = emailService;
    }

    @Override
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking read(String s) {
        return bookingRepository.findById(s).orElse(null);
    }

    @Override
    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }
    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
}

    public List<Booking> findBookingsByRoomNumber(String roomNumber){ return bookingRepository.findBookingByRoomRoomNumber(roomNumber); }

    public void sendBookingEmail(Guest guest, Room room, int numberOfGuests, LocalDateTime checkInDate, LocalDateTime checkOutDate) {
        String subject = "Booking Confirmation - Lily's Paradise BNB";

        String htmlMessage = generateBookingConfirmationEmail(
                guest.getName().getFirstName() + " " + guest.getName().getLastName(),
                guest.getEmail(),
                room.getRoomType(),
                numberOfGuests,
                checkInDate,
                checkOutDate,
                room.getRoomPrice()
        );

        try {
            emailService.sendVerificationEmail(guest.getEmail(), subject, htmlMessage);
        } catch (MessagingException exception) {
            throw new RuntimeException("Booking confirmation email not sent to " + guest.getEmail());
        }
    }

    private String generateBookingConfirmationEmail(String guestName, String guestEmail, String roomType,
                                                    int numberOfGuests, LocalDateTime checkInDate, LocalDateTime checkOutDate,
                                                    double roomPrice) {
        return "<html><body style=\"font-family: 'Arial', sans-serif; margin: 0; padding: 0; background-color: #f5f5f5;\">"
                + "<div style=\"max-width: 600px; margin: 20px auto; padding: 20px; background-color: #ffffff; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1);\">"
                + "<h1 style=\"color: #4CAF50; text-align: center;\">Booking Confirmation - Lily's Paradise BNB</h1>"
                + "<p style=\"font-size: 16px;\">Dear " + guestName + ",</p>"
                + "<p style=\"font-size: 16px;\">We are pleased to confirm your booking at Lily's Paradise BNB. Below are your booking details:</p>"

                + "<div style=\"background-color: #f1f1f1; padding: 15px; border-radius: 5px; margin: 20px 0;\">"
                + "<h3 style=\"color: #333;\">Booking Details</h3>"
                + "<p style=\"font-size: 16px;\">Room Type: " + roomType + "</p>"
                + "<p style=\"font-size: 16px;\">Price: R" + String.format("%.2f", roomPrice) + "</p>"
                + "<p style=\"font-size: 16px;\">Number of Guests: " + numberOfGuests + "</p>"
                + "<p style=\"font-size: 16px;\">Check-in: " + checkInDate + "</p>"
                + "<p style=\"font-size: 16px;\">Check-out: " + checkOutDate + "</p>"
                + "</div>"

                + "<p style=\"font-size: 16px;\">We look forward to hosting you at Lily's Paradise BNB. If you have any questions or need further assistance, feel free to reply to this email.</p>"
                + "<p style=\"font-size: 16px;\">Safe travels, and see you soon!</p>"

                + "<footer style=\"margin-top: 20px; text-align: center; font-size: 14px; color: #888;\">"
                + "<p>Best regards,</p>"
                + "<p>The Lily's Paradise BNB Team</p>"
                + "<p><a href=\"https://localhost:8081\" style=\"color: #4CAF50; text-decoration: none;\">Visit our website</a></p>"
                + "</footer>"
                + "</div>"
                + "</body></html>";
    }

}
