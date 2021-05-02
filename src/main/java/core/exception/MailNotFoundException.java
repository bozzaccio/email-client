package core.exception;

public class MailNotFoundException extends RuntimeException {

    public MailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailNotFoundException(String message) {
        super(message);
    }

    public MailNotFoundException(Throwable cause) {
        super(cause);
    }
}
