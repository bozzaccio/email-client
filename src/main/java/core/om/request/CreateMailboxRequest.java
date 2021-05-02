package core.om.request;

public class CreateMailboxRequest extends AbstractRequestModel {

    int count = 1;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
