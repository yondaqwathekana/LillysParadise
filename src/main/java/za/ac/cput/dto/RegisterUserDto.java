package za.ac.cput.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;

import java.util.Set;

@Getter
@Setter
@ToString
public class RegisterUserDto {
    private Name name;
    private Contact contact;
    private String email;
    private String password;
    private String username;
    private Set<String> roles;
}
