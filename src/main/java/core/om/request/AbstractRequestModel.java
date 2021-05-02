package core.om.request;

import core.om.ActionEnum;

public abstract class AbstractRequestModel {

    ActionEnum action;
    int messageId;

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
}
