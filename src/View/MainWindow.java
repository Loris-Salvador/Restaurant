package View;

import javax.swing.*;

public class MainWindow extends JFrame {

    private JPanel mainPanel = new JPanel();
    public MainWindow(JPanel panel, String title)
    {
        initComponents();
        setMainPanel(panel, title);

    }

    public void initComponents()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setMainPanel(JPanel panel, String title)
    {
        setContentPane(panel);
        setTitle(title);
    }

}
