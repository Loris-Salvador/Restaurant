package View;

import Model.DetailCommandeTableModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CuisinierView extends JPanel {

    public JList<String> commandesListe = new JList<>();
    public JTable detailcommandeTable = new JTable();
    public JButton pretButton = new JButton("Pret");
    public CuisinierView()
    {
        initComponent();
    }

    private void initComponent()
    {
        setLayout(new GridBagLayout());

        setBorder(new EmptyBorder(20,20,20,20));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy=0;
        gbc.gridx=0;
        gbc.anchor=GridBagConstraints.NORTHWEST;
        gbc.weighty = 1; // Ajuster le poids vertical pour que la colonne s'étende verticalement
        gbc.weightx= 1;

        JPanel colonne1 = new JPanel();
        colonne1.setLayout(new BorderLayout());

        // Créez un tableau bidimensionnel pour les données
        Object[][] data = {
                {"Donnée 1", "Donnée 2", "Donnée 3"},
                {"Donnée 4", "Donnée 5", "Donnée 6"},
                // Ajoutez plus de lignes si nécessaire
        };

        // Créez une instance du modèle de tableau avec les données
        DetailCommandeTableModel tableModel = new DetailCommandeTableModel(data);

        // Associez le modèle de tableau à votre JTable
        detailcommandeTable.setModel(tableModel);

        commandesListe.setBackground(Color.BLUE);
        colonne1.add(commandesListe, BorderLayout.NORTH);



        colonne1.add(pretButton, BorderLayout.SOUTH);

        add(colonne1, gbc);


    }



}
