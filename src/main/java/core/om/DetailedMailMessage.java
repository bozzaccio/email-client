package core.om;

import java.util.List;

public class DetailedMailMessage extends BaseMailMessage {

    private List<Attachment> attachments;
    private String body;
    private String textBody;
    private String htmlBody;

    public DetailedMailMessage() {
    }

    public DetailedMailMessage(DetailedMailMessageBuilder builder) {
        super(builder.id, builder.from, builder.subject, builder.date);
        this.attachments = builder.attachments;
        this.body = builder.body;
        this.textBody = builder.textBody;
        this.htmlBody = builder.htmlBody;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }

    public static class DetailedMailMessageBuilder {

        private final Integer id;
        private String from;
        private String subject;
        private String date;
        private List<Attachment> attachments;
        private String body;
        private String textBody;
        private String htmlBody;

        public DetailedMailMessageBuilder(Integer id) {
            this.id = id;
        }

        public DetailedMailMessageBuilder from(String from){
            this.from = from;
            return this;
        }

        public DetailedMailMessageBuilder subject(String subject){
            this.subject = subject;
            return this;
        }

        public DetailedMailMessageBuilder date(String date){
            this.date = date;
            return this;
        }

        public DetailedMailMessageBuilder attachments(List<Attachment> attachments){
            this.attachments = attachments;
            return this;
        }

        public DetailedMailMessageBuilder body(String body){
            this.body = body;
            return this;
        }

        public DetailedMailMessageBuilder textBody(String textBody){
            this.textBody = textBody;
            return this;
        }

        public DetailedMailMessageBuilder htmlBody(String htmlBody){
            this.htmlBody = htmlBody;
            return this;
        }

        public DetailedMailMessage build() {
            return new DetailedMailMessage(this);
        }
    }
}
