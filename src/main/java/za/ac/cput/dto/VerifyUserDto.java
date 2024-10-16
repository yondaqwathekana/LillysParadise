package za.ac.cput.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class VerifyUserDto {
    private String email;
    private String verificationCode;
}
