package component.panel;

import component.IComponentConfig;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {

    public Footer(){

        JButton sendButton = new JButton("SEND");

        this.setBackground(Color.PINK);
        this.setBounds(0, 400, IComponentConfig.WIDGET_WIDTH, 100);
        this.add(sendButton);
    }
}
