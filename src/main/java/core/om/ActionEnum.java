package core.om;

public enum ActionEnum {
    GEN_RANDOM_MAILBOX("genRandomMailbox"),
    DOWNLOAD_ATTACHMENT("download"),
    GET_MESSAGES("getMessages"),
    READ_MESSAGE("readMessage");

    private final String actionName;

    ActionEnum(String name) {
        actionName = name;
    }

    @Override
    public String toString() {
        return this.actionName;
    }
}
