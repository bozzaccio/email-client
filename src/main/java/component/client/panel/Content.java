package component.client.panel;

import core.IComponentConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Content extends JPanel {

    private JTable mailTable;

    public Content() {

        this.setBounds(0, 100, IComponentConfig.COMPONENT_WIDTH, 300);

        mailTable = new JTable();

        String[] tableColumns = new String[]{"from", "subject", "date"};
        Object[][] rows = new Object[][]{};

        DefaultTableModel tableModel = new DefaultTableModel(rows, tableColumns) {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        mailTable.setModel(tableModel);
        mailTable.revalidate();

        JScrollPane scrollPane = new JScrollPane(mailTable);

        this.add(scrollPane);
    }

    public JTable getMailTable() {
        return mailTable;
    }

    public void setMailTable(JTable mailTable) {
        this.mailTable = mailTable;
    }
}
