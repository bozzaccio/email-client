package core.om.request;

import core.om.ActionEnum;

import java.io.Serializable;

public class CreateMailboxRequest extends AbstractRequestModel implements Serializable {

    private static final long serialVersionUID = -5134436289651916531L;

    private int count = 1;

    public CreateMailboxRequest(int count) {
        this.count = count;
        this.setAction(ActionEnum.GEN_RANDOM_MAILBOX);
    }

    public CreateMailboxRequest() {
        this.setAction(ActionEnum.GEN_RANDOM_MAILBOX);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
