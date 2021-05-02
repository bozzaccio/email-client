package core.exception;

public class MailNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1245207362111712250L;

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
