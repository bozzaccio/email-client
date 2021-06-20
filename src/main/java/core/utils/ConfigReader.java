package core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import core.AppConfig;
import core.exception.ConfigurationNotFoundException;
import core.om.config.ApiConfig;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ConfigReader {

    public static boolean loadConfig() throws IOException, ConfigurationNotFoundException {

        // Loading the YAML file from the /resources folder
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("application.yaml")).getFile());

        // Instantiating a new ObjectMapper as a YAMLFactory
        ObjectMapper om = new ObjectMapper(new YAMLFactory());

        if(file.exists()) {
            AppConfig appConfig = om.readValue(file, AppConfig.class);

            if(Objects.nonNull(appConfig)
                    && Objects.nonNull(appConfig.getApi())
                    && Objects.nonNull(appConfig.getSmtp())){

                AppConfig.apiConfig = appConfig.getApi();
                AppConfig.smtpConfig = appConfig.getSmtp();

                return true;
            } else {
                throw new ConfigurationNotFoundException("Configuration parameter are incorrect");
            }
        } else {
            throw new ConfigurationNotFoundException();
        }
    }
}
