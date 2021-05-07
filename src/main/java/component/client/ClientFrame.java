package component.client;

import controller.EmailController;
import core.Global;
import core.IComponentConfig;
import component.client.panel.Content;
import component.client.panel.Footer;
import component.client.panel.Header;
import core.om.response.GetAllMailResponse;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class ClientFrame extends JFrame {

    EmailController controller = new EmailController();

    public ClientFrame() throws HeadlessException {
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

        footer.getRefreshButton().addActionListener(e -> {
            String username = Global.emailAddress.substring(0, Global.emailAddress.indexOf('@'));
            String domain = Global.emailAddress.substring(Global.emailAddress.indexOf('@'));
            try {
                GetAllMailResponse response = controller.getAllMailOfMailbox(username, domain);


                String[] tableColumns = new String[]{"from", "subject", "date"};
                Object[][] rows = new Object[][]{
                        { "dm5wolyd9z@wwjmp.com", "Subject", "2021-05-07 17:26:33"}
                };



                DefaultTableModel tableModel = new DefaultTableModel(rows, tableColumns);
                content.getMailTable().setModel(tableModel);
                content.getMailTable().revalidate();
            } catch (IOException | URISyntaxException | InterruptedException exception) {
                exception.printStackTrace();
            }
        });
    }
}
