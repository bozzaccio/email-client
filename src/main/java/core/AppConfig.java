package core;

import core.om.config.ApiConfig;
import core.om.config.SmtpConfig;

public class AppConfig {

    public static String emailAddress;
    public static ApiConfig apiConfig;
    public static SmtpConfig smtpConfig;

    private ApiConfig api;
    private SmtpConfig smtp;

    public AppConfig(ApiConfig api, SmtpConfig smtp) {
        this.api = api;
        this.smtp = smtp;
    }

    public AppConfig() {}

    public ApiConfig getApi() {
        return api;
    }

    public void setApi(ApiConfig api) {
        this.api = api;
    }

    public SmtpConfig getSmtp() {
        return smtp;
    }

    public void setSmtp(SmtpConfig smtp) {
        this.smtp = smtp;
    }
}
