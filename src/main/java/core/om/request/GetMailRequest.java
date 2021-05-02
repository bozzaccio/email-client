package core.om.request;

import core.om.ActionEnum;

import java.io.Serializable;

public class GetMailRequest extends AbstractRequestModel implements Serializable {

    private static final long serialVersionUID = -1404554472418778815L;

    private String username;
    private String domain;

    public GetMailRequest(String username, String domain, int id) {
        this.username = username;
        this.domain = domain;
        this.setMessageId(id);
        this.setAction(ActionEnum.READ_MESSAGE);
    }

    public GetMailRequest() {
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
