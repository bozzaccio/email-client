package component;

import core.IComponentConfig;
import component.panel.Content;
import component.panel.Footer;
import component.panel.Header;

import javax.swing.*;
import java.awt.*;

public class ComponentFrame extends JFrame {

    public ComponentFrame() throws HeadlessException {
        Header header = new Header();
        Content content = new Content();
        Footer footer = new Footer();

        this.setTitle("E-Mail Client");
        this.setSize(IComponentConfig.COMPONENT_WIDTH, IComponentConfig.COMPONENT_HEIGHT);
        this.setVisible(Boolean.TRUE);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(Boolean.FALSE);

        this.add(header);
        this.add(content);
        this.add(footer);
    }
}
