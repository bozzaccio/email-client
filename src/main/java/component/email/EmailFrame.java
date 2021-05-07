package component.email;

import component.email.panel.EmailForm;
import controller.api.mail.CreateMail;
import core.Global;
import core.IComponentConfig;
import core.om.request.CreateMailRequest;

import javax.swing.*;
import java.awt.*;

public class EmailFrame extends JFrame {

    public EmailFrame() throws HeadlessException {

        EmailForm emailForm = new EmailForm();

        this.setTitle("Create new email");
        this.setSize(IComponentConfig.COMPONENT_WIDTH / 2, IComponentConfig.COMPONENT_HEIGHT);
        this.setVisible(Boolean.TRUE);
        this.setResizable(Boolean.FALSE);
        this.add(emailForm);

        emailForm.getSendButton().addActionListener(e -> {
            if(e.getSource() == emailForm.getSendButton()){
                CreateMailRequest request = new CreateMailRequest();
                request.setEmailTo(emailForm.getToField().getText());
                request.setEmailFrom(Global.emailAddress);
                request.setEmailSubject(emailForm.getSubjectField().getText());
                request.setEmailText(emailForm.getContentArea().getText());
                CreateMail.send(request);
                this.dispose();
            }
        });
    }
}
