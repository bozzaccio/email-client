package core.om.request;

import core.om.ActionEnum;

import java.io.Serializable;

public class GetAttachmentRequest extends AbstractRequestModel implements Serializable {

    private static final long serialVersionUID = -7141392731329321974L;

    private String username;
    private String domain;
    private String fileName;

    public GetAttachmentRequest(String username, String domain, String fileName, int id) {
        this.username = username;
        this.domain = domain;
        this.fileName = fileName;
        this.setAction(ActionEnum.DOWNLOAD_ATTACHMENT);
        this.setMessageId(id);
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
