package za.ac.cput.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class VerifyGuestDto {
    private String email;
    private String verificationCode;
}
