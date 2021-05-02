package component.panel;

import core.IComponentConfig;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {

    public Content(){

        JLabel contentLabel = new JLabel("TO E-MAIL ADDRESS: ");

        JTextField toField = new JTextField();
        toField.setPreferredSize(new Dimension(200,40));

        this.setBackground(Color.LIGHT_GRAY);
        this.setBounds(0, 100, IComponentConfig.COMPONENT_WIDTH, 300);
        this.add(contentLabel);
        this.add(toField);
    }
}
