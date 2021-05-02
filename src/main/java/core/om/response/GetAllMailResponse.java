package core.om.response;

import core.om.BaseMailMessage;

import java.io.Serializable;
import java.util.List;

public class GetAllMailResponse implements Serializable {

    private static final long serialVersionUID = -4367659396326477927L;

    private List<BaseMailMessage> mailMessageList;

    public List<BaseMailMessage> getMailMessageList() {
        return mailMessageList;
    }

    public void setMailMessageList(List<BaseMailMessage> mailMessageList) {
        this.mailMessageList = mailMessageList;
    }
}
