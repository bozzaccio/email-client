package component.panel;

import component.IComponentConfig;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {

    public Header(){

        this.setBackground(Color.CYAN);
        this.setBounds(0, 0, IComponentConfig.WIDGET_WIDTH, 100);
    }
}
