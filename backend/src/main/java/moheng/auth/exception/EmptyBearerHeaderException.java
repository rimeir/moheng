package moheng.auth.exception;

public class EmptyBearerHeaderException extends RuntimeException {
    public EmptyBearerHeaderException(String message) {
        super(message);
    }
}
