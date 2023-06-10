package View;

import Controller.ServeurController;
import Model.Categorie;
import Model.Commande;
import Model.MenuItem;
import Model.Plat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ServeurMainView extends JPanel {

    public JLabel categorieLabel = new JLabel("Categorie");
    public JLabel nombreLabel = new JLabel("Nombre");
    public JComboBox<String> categorieComboBox = new JComboBox<>();
    private DefaultListModel<MenuItem> listModelItem = new DefaultListModel<>();
    private DefaultListModel<Commande> listModelCommande = new DefaultListModel<>();
    public JComboBox<Integer> nombreComboBox = new JComboBox<>();
    public JList<MenuItem> menuItemJList = new JList<>(listModelItem);
    public JButton addButton = new JButton("AJOUTER");
    public JList<Commande> commandeList = new JList<>(listModelCommande);
    public JButton addButton2 = new JButton("AJOUTER");
    public JButton SupprimerButton = new JButton("Supprimer");

    public ServeurMainView() {
        initComponent();
    }

    private void initComponent() {
        setLayout(new GridBagLayout());

        JPanel colonne1 = new JPanel();
        colonne1.setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour la colonne 1
        colonne1.setBorder(new EmptyBorder(7, 20, 0, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.WEST;

        categorieComboBox.setMaximumSize(new Dimension(230, categorieComboBox.getMaximumSize().height));
        categorieComboBox.addItem("Plat");
        categorieComboBox.addItem("Entree");
        categorieComboBox.addItem("Dessert");
        categorieComboBox.addItem("Boisson");



        JPanel test = new JPanel();
        test.setLayout(new BorderLayout());
        test.add(categorieComboBox, BorderLayout.WEST);

        JPanel test2 = new JPanel();
        test2.setLayout(new BorderLayout());
        test2.add(nombreComboBox, BorderLayout.WEST);
        colonne1.add(categorieLabel, gbc);
        gbc.gridy++;
        colonne1.add(test, gbc);
        gbc.gridy++;
        colonne1.add(nombreLabel, gbc);
        gbc.gridy++;
        colonne1.add(test2, gbc);
        gbc.gridy++;
        colonne1.add(new JScrollPane(menuItemJList), gbc);
        gbc.gridy++;
        colonne1.add(addButton, gbc);

        JPanel colonne2 = new JPanel();
        colonne2.setLayout(new BoxLayout(colonne2, BoxLayout.Y_AXIS));
        colonne2.add(new JScrollPane(commandeList));
        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout());
        panelButton.add(addButton2);
        panelButton.add(SupprimerButton);
        colonne2.add(Box.createRigidArea(new Dimension(0, 20)));
        colonne2.add(panelButton);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.weightx = 1;
        gbc2.weighty = 1;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.anchor = GridBagConstraints.WEST;

        add(colonne1, gbc2);
        gbc2.gridx = 1;
        gbc2.anchor = GridBagConstraints.EAST;
        add(colonne2, gbc2);
    }

    public void setController(ServeurController serveurController)
    {
        categorieComboBox.addActionListener(serveurController);
    }
}
