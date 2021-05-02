package component.panel;

import controller.EmailController;
import core.IComponentConfig;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {

    EmailController controller = new EmailController();

    public Header() {

        JButton generateEmail = new JButton("GENERATE E-MAIL");
        generateEmail.addActionListener(e -> {
            try {
                controller.getNewMailbox();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        this.add(generateEmail);

//        JButton getAllMail = new JButton("REFRESH INBOX MAIL");
//        getAllMail.addActionListener(e -> {
//            try {
//                controller.getAllMails();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//        this.add(getAllMail);

        this.setBackground(Color.CYAN);
        this.setBounds(0, 0, IComponentConfig.COMPONENT_WIDTH, 100);
    }
}
