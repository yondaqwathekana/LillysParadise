package za.ac.cput.response;

public class LoginResponse {
    private String message;

    // Constructor
    public LoginResponse(String message) {
        this.message = message;
    }

    // Getter and Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
