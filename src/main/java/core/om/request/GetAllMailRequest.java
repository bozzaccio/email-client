package core.om.request;

import core.om.ActionEnum;

import java.io.Serializable;

public class GetAllMailRequest extends AbstractRequestModel implements Serializable {

    private static final long serialVersionUID = -8912239552327545395L;

    private String username;
    private String domain;

    public GetAllMailRequest(String username, String domain) {
        this.username = username;
        this.domain = domain;
        this.setAction(ActionEnum.GET_MESSAGES);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
