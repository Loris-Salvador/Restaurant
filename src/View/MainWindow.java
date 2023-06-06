package View;

import Controller.MainWindowController;

import javax.swing.*;

public class MainWindow extends JFrame {

    //private JPanel mainPanel = new JPanel();
    public JMenuBar menuBar = new JMenuBar();
    public JMenu menu = new JMenu("Deconnexion");
    public MainWindow(JPanel panel, String title)
    {
        initComponents();
        setMainPanel(panel, title);
    }

    public void initComponents()
    {
        setJMenuBar(menuBar);
        menuBar.add(menu);

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

    public void setController(MainWindowController mainWindowController)
    {
        menu.addMenuListener(mainWindowController);
    }

}
