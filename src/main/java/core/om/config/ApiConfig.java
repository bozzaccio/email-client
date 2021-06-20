package core.om.config;

public class ApiConfig {

    private String protocol;
    private String url;
    private String path;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getApiUrl() {
        return protocol.concat("://").concat(url).concat("/").concat(path);
    }
}
