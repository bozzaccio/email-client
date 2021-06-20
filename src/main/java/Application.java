import component.client.ClientFrame;
import core.exception.ConfigurationNotFoundException;
import core.utils.ConfigReader;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {

        try {
            if (ConfigReader.loadConfig()) {
                new ClientFrame();
            }
        } catch (IOException | ConfigurationNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
