package component.client;

import component.client.panel.Content;
import component.client.panel.Footer;
import component.client.panel.Header;
import controller.EmailController;
import core.AppConfig;
import core.IComponentConfig;
import core.om.BaseMailMessage;
import core.om.response.GetAllMailResponse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
            String username = AppConfig.emailAddress
                    .substring(0, AppConfig.emailAddress.indexOf('@'));
            String domain = AppConfig.emailAddress
                    .substring(AppConfig.emailAddress.indexOf('@'))
                    .replace("@", "");
            try {
                GetAllMailResponse response = controller.getAllMailOfMailbox(username, domain);

                DefaultTableModel model = (DefaultTableModel) content.getMailTable().getModel();

                model.setRowCount(0);

                if (Objects.nonNull(response.getMailMessageList()) && response.getMailMessageList().size() > 0) {

                    response.getMailMessageList().forEach(message -> {
                        model.addRow(BaseMailMessage.getMailMessageObj(message));
                    });
                }

            } catch (IOException | URISyntaxException | InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        content.getMailTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                int rowId = table.rowAtPoint(mouseEvent.getPoint());

                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    System.out.println(rowId);
                }
            }
        });
    }

    public static void start() {
        new ClientFrame();
    }
}
