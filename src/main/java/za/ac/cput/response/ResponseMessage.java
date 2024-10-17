package za.ac.cput.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessage {
    private String message;
    private String status;

    public ResponseMessage(String message, String status){
        this.message = message;
        this.status = status;
    }
}
