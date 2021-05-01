import javax.swing.JFrame;

public class Application {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("E-Mail Client");
        frame.setSize(400,400);
        frame.setVisible(Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(Boolean.FALSE);
    }
}
