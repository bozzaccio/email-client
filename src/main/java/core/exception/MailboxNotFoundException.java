package core.exception;

public class MailboxNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 3778681913461645806L;

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
