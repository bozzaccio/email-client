package core.om.response;

import core.om.StatusEnum;

import java.io.Serializable;

public class CreateMailResponse implements Serializable {

    private static final long serialVersionUID = 6975638008749491632L;

    private StatusEnum status;

    public CreateMailResponse(StatusEnum status) {
        this.status = status;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
