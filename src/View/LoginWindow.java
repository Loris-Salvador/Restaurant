package View;

import Controller.LoginController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginWindow extends JFrame {
    private JPanel statusPanel = new JPanel();
    public JButton clientButton = new JButton("Un client");
    public JButton personnelButton = new JButton("Un membre du personnel");
    public JButton adminButton = new JButton("Un administrateur");
    public JButton serveurButton = new JButton("Serveur");
    public JButton cuistotButton = new JButton("Cuisinier");
    public JButton barmanButton = new JButton("Barman");
    public JLabel userLabel = new JLabel("nom d'utilisateur :");
    public JLabel mdpLabel = new JLabel("mot de passe :");
    public JTextField userTextField = new JTextField("");
    public JTextField mdpTextField = new JTextField("");
    public JButton loginButton = new JButton("Login");
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
        StyleButton(adminButton);


        statusPanel.add(statusLabel);
        statusPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        statusPanel.add(clientButton);
        statusPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        statusPanel.add(personnelButton);
        statusPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        statusPanel.add(adminButton);


        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));
        statusPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        statusPanel.setBackground(Color.WHITE);


        // Ajout du panneau principal à la fenêtre
        setContentPane(statusPanel);

        // Configuration de la fenêtre
        setTitle("Login");
        setSize(300, 190);
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

        setSize(285, 150);
        setContentPane(personnelPanel);
        revalidate();
    }

    public void Login() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        loginButton.setBackground(new Color(0x25ACFF));
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 5, 10); // Marge entre les composants

        gbc.fill = GridBagConstraints.HORIZONTAL; // Composant extensible horizontalement

        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(userLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(mdpLabel, gbc);

        gbc.weightx = 1.0; // Poids horizontal pour remplir l'espace disponible

        gbc.gridx = 1;
        gbc.gridy = 1;
        loginPanel.add(mdpTextField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        loginPanel.add(userTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Le bouton s'étend sur deux colonnes
        gbc.fill = GridBagConstraints.NONE; // Désactiver l'extension du bouton
        gbc.anchor = GridBagConstraints.EAST; // Aligner le bouton à droite
        loginPanel.add(loginButton, gbc);

        setSize(280, 150);
        setContentPane(loginPanel);
        revalidate();
    }


    public void setController(LoginController loginController)
    {
        clientButton.addActionListener(loginController);
        personnelButton.addActionListener(loginController);
        serveurButton.addActionListener(loginController);
        cuistotButton.addActionListener(loginController);
        barmanButton.addActionListener(loginController);
        loginButton.addActionListener(loginController);
        adminButton.addActionListener(loginController);
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
