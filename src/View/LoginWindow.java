package View;

import Controller.LoginController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginWindow extends JFrame {

    private JPanel statusPanel = new JPanel();
    public JButton clientButton = new JButton("Un client");
    public JButton personnelButton = new JButton("Un membre du personnel");
    public LoginWindow()
    {
        initComponent();
    }

    private void initComponent()
    {
        JLabel statusLabel = new JLabel("Etes-vous");
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        clientButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clientButton.setBackground(new Color(0xBC0101));
        clientButton.setForeground(Color.WHITE);
        clientButton.setFocusPainted(false);
        clientButton.setBorderPainted(false);

        personnelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        personnelButton.setForeground(Color.WHITE);
        personnelButton.setBackground(new Color(0xBC0101));
        personnelButton.setFocusPainted(false);
        personnelButton.setBorderPainted(false);


        statusPanel.add(statusLabel);
        statusPanel.add(Box.createRigidArea(new Dimension(0, 15))); // Ajoute un espace vertical de 10 pixels
        statusPanel.add(clientButton);
        statusPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Ajoute un espace vertical de 10 pixels
        statusPanel.add(personnelButton);


        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));
        statusPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        statusPanel.setBackground(Color.WHITE);



        // Ajout du panneau principal à la fenêtre
        setContentPane(statusPanel);

        // Configuration de la fenêtre
        setTitle("Login");
        setSize(300, 150);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setController(LoginController loginController)
    {
        clientButton.addActionListener(loginController);
        personnelButton.addActionListener(loginController);
    }

    public static void main(String[] args) {
        LoginWindow l = new LoginWindow();
    }
}
