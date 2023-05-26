package View;

import Controller.LoginController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginWindow extends JFrame {

    private JPanel statusPanel = new JPanel();
    public JButton clientButton = new JButton("Un client");
    public JButton personnelButton = new JButton("Un membre du personnel");
    public JButton serveurButton = new JButton("Serveur");
    public JButton cuistotButton = new JButton("Cuistot");
    public JButton barmanButton = new JButton("Barman");
    public LoginWindow()
    {
        initComponent();
    }

    private void initComponent()
    {
        JLabel statusLabel = new JLabel("Etes-vous");
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        StyleButton(clientButton);

        StyleButton(personnelButton);


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

    public void Personnel()
    {
        JPanel personnelPanel = new JPanel();
        personnelPanel.setLayout(new BoxLayout(personnelPanel, BoxLayout.Y_AXIS));
        personnelPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        personnelPanel.setBackground(Color.WHITE);

        StyleButton(serveurButton);
        StyleButton(cuistotButton);
        StyleButton(barmanButton);

        personnelPanel.add(serveurButton);
        personnelPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Ajoute un espace vertical de 10 pixels
        personnelPanel.add(cuistotButton);
        personnelPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Ajoute un espace vertical de 10 pixels
        personnelPanel.add(barmanButton);

        setContentPane(personnelPanel);
        revalidate();

    }

    public void setController(LoginController loginController)
    {
        clientButton.addActionListener(loginController);
        personnelButton.addActionListener(loginController);
        serveurButton.addActionListener(loginController);
        cuistotButton.addActionListener(loginController);
        barmanButton.addActionListener(loginController);
    }

    private void StyleButton(JButton button)
    {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0xBC0101));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
    }

    public static void main(String[] args) {
        LoginWindow l = new LoginWindow();
    }
}
