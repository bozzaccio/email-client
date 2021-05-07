package controller;

import controller.api.mailbox.CreateMailbox;
import controller.api.mail.GetAllMail;
import controller.api.mail.GetMail;
import controller.api.mail.GetMailAttachment;
import core.exception.MailNotFoundException;
import core.exception.MailboxNotFoundException;
import core.om.request.CreateMailboxRequest;
import core.om.request.GetAllMailRequest;
import core.om.request.GetAttachmentRequest;
import core.om.request.GetMailRequest;
import core.om.response.CreateMailboxResponse;
import core.om.response.GetAllMailResponse;
import core.om.response.GetAttachmentResponse;
import core.om.response.GetMailResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public class EmailController {

    public CreateMailboxResponse getNewMailbox() throws IOException, InterruptedException, URISyntaxException {

        CreateMailbox createMailbox = new CreateMailbox();
        CreateMailboxRequest request = new CreateMailboxRequest();
        CreateMailboxResponse response;

        try {
            response = createMailbox.execute(request);
        } catch (RuntimeException ex) {
            throw new MailboxNotFoundException(ex);
        }

        return response;
    }

    public GetAllMailResponse getAllMailOfMailbox(String username, String domain) throws IOException, URISyntaxException, InterruptedException {

        GetAllMail getAllMail = new GetAllMail();
        GetAllMailRequest request = new GetAllMailRequest(username, domain);
        GetAllMailResponse response;

        try {
            response = getAllMail.execute(request);
        } catch (RuntimeException ex) {
            throw new MailboxNotFoundException(ex);
        }

        return response;
    }

    public GetMailResponse getMail(String username, String domain, int mailId) throws IOException, URISyntaxException, InterruptedException {

        GetMail getMail = new GetMail();
        GetMailRequest request = new GetMailRequest(username, domain, mailId);
        GetMailResponse response;

        try {
            response = getMail.execute(request);
        } catch (RuntimeException ex) {
            throw new MailNotFoundException(ex);
        }

        return response;
    }

    public GetAttachmentResponse getAttachment(String username, String domain, int mailId, String fileName) {

        GetMailAttachment getMailAttachment = new GetMailAttachment();
        GetAttachmentRequest request = new GetAttachmentRequest(username, domain, fileName, mailId);
        GetAttachmentResponse response;

        try {
            response = getMailAttachment.execute(request);
        } catch (RuntimeException | IOException ex) {
            throw new MailNotFoundException(ex);
        }

        return response;
    }
}
