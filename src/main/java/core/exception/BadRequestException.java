package core.exception;

public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 408737083587039113L;

    public BadRequestException() {
        super("Error! Bad Request.");
    }

    public BadRequestException(String message) {
        super(message);
    }
}
