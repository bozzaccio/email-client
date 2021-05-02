package component.panel;

import core.IComponentConfig;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {

    public Footer(){

        JButton sendButton = new JButton("SEND");

        this.setBackground(Color.PINK);
        this.setBounds(0, 400, IComponentConfig.COMPONENT_WIDTH, 100);
        this.add(sendButton);
    }
}
