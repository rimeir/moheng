package moheng.auth.presentation;

public class InvalidTokenFormatException extends RuntimeException {
    public InvalidTokenFormatException(String message) {
        super(message);
    }
}
