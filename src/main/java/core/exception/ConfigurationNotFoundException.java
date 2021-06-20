package core.exception;

public class ConfigurationNotFoundException extends Exception {

    private static final long serialVersionUID = 4583300258513378636L;

    public ConfigurationNotFoundException() {
        super("Configuration file not found on project resources");
    }

    public ConfigurationNotFoundException(String message) {
        super(message);
    }
}
