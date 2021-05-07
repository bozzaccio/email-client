package component.email.panel;

import javax.swing.*;
import java.awt.*;

import static core.IComponentConfig.*;

public class EmailForm extends JPanel {

    private JButton sendButton;
    private JTextField toField;
    private JTextField subjectField;
    private JTextArea contentArea;

    public EmailForm() {

        JLabel toLabel = new JLabel("To:");
        setToField(new JTextField());
        getToField().setPreferredSize(new Dimension(200, BUTTON_HEIGHT));

        JLabel subjectLabel = new JLabel("Subject:");
        setSubjectField(new JTextField());
        getSubjectField().setPreferredSize(new Dimension(200, BUTTON_HEIGHT));

        JLabel contentLabel = new JLabel("E-Mail Content: ");
        setContentArea(new JTextArea());
        getContentArea().setPreferredSize(new Dimension(COMPONENT_WIDTH / 2 - 40, LARGE_PX_SIZE + SMALL_PX_SIZE));
        getContentArea().setLineWrap(true);
        getContentArea().setWrapStyleWord(true);

        setSendButton(new JButton("SEND"));

        this.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
        this.add(toLabel);
        this.add(getToField());
        this.add(subjectLabel);
        this.add(getSubjectField());
        this.add(contentLabel);
        this.add(getContentArea());
        this.add(getSendButton());
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public void setSendButton(JButton sendButton) {
        this.sendButton = sendButton;
    }

    public JTextField getToField() {
        return toField;
    }

    public void setToField(JTextField toField) {
        this.toField = toField;
    }

    public JTextField getSubjectField() {
        return subjectField;
    }

    public void setSubjectField(JTextField subjectField) {
        this.subjectField = subjectField;
    }

    public JTextArea getContentArea() {
        return contentArea;
    }

    public void setContentArea(JTextArea contentArea) {
        this.contentArea = contentArea;
    }
}
