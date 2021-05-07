package component.client.panel;

import component.email.EmailFrame;

import javax.swing.*;
import java.awt.*;

import static core.IComponentConfig.COMPONENT_WIDTH;
import static core.IComponentConfig.SMALL_PX_SIZE;

public class Footer extends JPanel {

    private final JButton refreshButton;

    public Footer() {

        JButton sendButton = new JButton("CREATE NEW E-MAIL");
        sendButton.addActionListener(e -> new EmailFrame());

        refreshButton = new JButton("REFRESH E-MAIL");

        this.setLayout(new FlowLayout(FlowLayout.CENTER,10, 10));
        this.setBackground(Color.LIGHT_GRAY);
        this.setBounds(0, 400, COMPONENT_WIDTH, SMALL_PX_SIZE);
        this.add(sendButton);
        this.add(refreshButton);
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }
}
