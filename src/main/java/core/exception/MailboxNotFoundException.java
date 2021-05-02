package core.exception;

public class MailboxNotFoundException extends RuntimeException {

    public MailboxNotFoundException(String message) {
        super(message);
    }

    public MailboxNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailboxNotFoundException(Throwable cause) {
        super(cause);
    }
}
