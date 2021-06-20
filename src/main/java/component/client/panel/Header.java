package component.client.panel;

import controller.EmailController;
import core.AppConfig;
import core.om.response.CreateMailboxResponse;

import javax.swing.*;

import static core.IComponentConfig.*;

public class Header extends JPanel {

    EmailController controller = new EmailController();

    private static final int PANEL_CENTER_Y = 20;

    public Header() {


        JTextField emailAddress = new JTextField();
        emailAddress.setEditable(Boolean.FALSE);
        emailAddress.setBounds(350, PANEL_CENTER_Y, LARGE_PX_SIZE, BUTTON_HEIGHT);

        JLabel emailLabel = new JLabel("Your temporary e-mail:");
        emailLabel.setBounds(190, PANEL_CENTER_Y, LARGE_PX_SIZE, BUTTON_HEIGHT);

        JButton generateEmail = new JButton("GENERATE E-MAIL");
        generateEmail.setVerticalAlignment(JButton.TOP);
        generateEmail.setHorizontalAlignment(JButton.LEFT);
        generateEmail.setBounds(20, PANEL_CENTER_Y, MEDIUM_PX_SIZE, BUTTON_HEIGHT);

        generateEmail.addActionListener(e -> {
            try {
                CreateMailboxResponse response = controller.getNewMailbox();

                if (response.getEmailAddressSet().stream().findFirst().isPresent()) {
                    emailAddress.setText(response.getEmailAddressSet().stream().findFirst().get());
                    AppConfig.emailAddress = emailAddress.getText();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        this.add(generateEmail);
        this.add(emailLabel);
        this.add(emailAddress);

        this.setLayout(null);
        this.setBounds(0, 0, COMPONENT_WIDTH, SMALL_PX_SIZE);
    }
}
