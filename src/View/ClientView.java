package View;

import Controller.ClientController;
import Controller.LoginController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ClientView extends JPanel {

    public JLabel reserverLabel= new JLabel("Réserver :");
    public JLabel momentLabel = new JLabel("Quand souhaitez-vous venir ?");
    public JComboBox<String> momentComboBox = new JComboBox<>();
    public JLabel nbPersonneLabel = new JLabel("Nombre de personnes");
    public JComboBox<String> mnbPersonnesComboBox = new JComboBox<>();
    public JLabel jourLabel = new JLabel("Choisissez un jour");
    public JComboBox<String> jourComboBox = new JComboBox<>();
    public JLabel nomReservationLabel = new JLabel("Nom de réservation");
    public JTextField nomReservationTextField = new JTextField("");
    public JLabel plusDePlaceLabel = new JLabel("<html>Desolé nous n'avons<br>plus de place pour cette date</html>");
    public JButton menuButton = new JButton("Voir menu");
    public JButton reserverButton = new JButton("Réserver");
    public JLabel choixHeureLabel = new JLabel("Choisissez une heure");
    public JList<String> plageHoraireList = new JList<>();

    public ClientView()
    {
        initComponent();
    }

    private void initComponent()
    {
        nbPersonneLabel.setVisible(false);
        mnbPersonnesComboBox.setVisible(false);
        jourLabel.setVisible(false);
        jourComboBox.setVisible(false);
        reserverButton.setVisible(false);
        plusDePlaceLabel.setVisible(false);
        nomReservationLabel.setVisible(false);
        nomReservationTextField.setVisible(false);

        //

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JPanel colonne1 = new JPanel();
        colonne1.setLayout(new BoxLayout(colonne1, BoxLayout.Y_AXIS));
        colonne1.setBorder(new EmptyBorder(7,20,0,0));
        colonne1.setAlignmentX(RIGHT_ALIGNMENT);



        momentComboBox.setMaximumSize(new Dimension(230, momentComboBox.getMaximumSize().height));
        momentComboBox.addItem("");
        momentComboBox.addItem("Midi");
        momentComboBox.addItem("Soirée");

        jourComboBox.setMaximumSize(new Dimension(230, momentComboBox.getMaximumSize().height));
        jourComboBox.addItem("");
        jourComboBox.addItem("29/06");

        mnbPersonnesComboBox.setMaximumSize(new Dimension(230, momentComboBox.getMaximumSize().height));
        mnbPersonnesComboBox.addItem("");
        mnbPersonnesComboBox.addItem("1");


        JPanel test = new JPanel();
        test.setLayout(new BorderLayout());
        momentComboBox.setAlignmentX(LEFT_ALIGNMENT);
        test.add(momentComboBox, BorderLayout.WEST);
        test.setAlignmentX(LEFT_ALIGNMENT);

        JPanel test2 = new JPanel();
        test2.setLayout(new BorderLayout());
        jourComboBox.setAlignmentX(LEFT_ALIGNMENT);
        test2.add(jourComboBox, BorderLayout.WEST);
        test2.setAlignmentX(LEFT_ALIGNMENT);

        JPanel test3 = new JPanel();
        test3.setLayout(new BorderLayout());
        mnbPersonnesComboBox.setAlignmentX(LEFT_ALIGNMENT);
        test3.add(mnbPersonnesComboBox, BorderLayout.WEST);
        test3.setAlignmentX(LEFT_ALIGNMENT);


        mnbPersonnesComboBox.setMaximumSize(new Dimension(230, momentComboBox.getMaximumSize().height));
        jourComboBox.setMaximumSize(new Dimension(230, momentComboBox.getMaximumSize().height));
        plusDePlaceLabel.setForeground(Color.RED);
        reserverLabel.setFont(new Font("", Font.PLAIN, 18));

        colonne1.add(reserverLabel);
        colonne1.add(Box.createRigidArea(new Dimension(0, 20)));
        colonne1.add(momentLabel);
        colonne1.add(Box.createRigidArea(new Dimension(0, 10)));
        colonne1.add(test);
        colonne1.add(Box.createRigidArea(new Dimension(0, 15)));
        colonne1.add(nbPersonneLabel);
        colonne1.add(Box.createRigidArea(new Dimension(0, 10)));
        colonne1.add(test3);
        colonne1.add(Box.createRigidArea(new Dimension(0, 15)));
        colonne1.add(jourLabel);
        colonne1.add(Box.createRigidArea(new Dimension(0, 10)));
        colonne1.add(test2);
        colonne1.add(Box.createRigidArea(new Dimension(0, 15)));
        colonne1.add(nomReservationLabel);
        colonne1.add(Box.createRigidArea(new Dimension(0, 10)));
        colonne1.add(nomReservationTextField);
        colonne1.add(Box.createRigidArea(new Dimension(0, 20)));
        colonne1.add(plusDePlaceLabel);

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weighty = 1; // Ajuster le poids vertical pour que la colonne s'étende verticalement
        gbc.anchor = GridBagConstraints.NORTHWEST;

        gbc.weightx=0.2;

        add(colonne1, gbc);


        JPanel colonne2 = new JPanel();
        colonne2.setLayout(new BorderLayout());


        gbc.weightx=0.3;
        colonne2.setBorder(new EmptyBorder(15,0,15,0));        colonne2.add(menuButton, BorderLayout.NORTH);
        colonne2.add(reserverButton, BorderLayout.SOUTH);

        gbc.gridx=1;
        gbc.fill=GridBagConstraints.VERTICAL;


        add(colonne2, gbc);

        JPanel colonne3 = new JPanel();
        colonne3.setLayout(new BoxLayout(colonne3, BoxLayout.Y_AXIS));
        colonne3.setBorder(new EmptyBorder(10,10,10,40));
        choixHeureLabel.setBorder(new EmptyBorder(7,10,10,10));
        choixHeureLabel.setBorder(new EmptyBorder(0, 10,20,10));

        plageHoraireList.setMaximumSize(new Dimension(150, momentComboBox.getMaximumSize().height));
        plageHoraireList.setCellRenderer(new DefaultListCellRenderer());


        plageHoraireList.setAlignmentX(Component.LEFT_ALIGNMENT);
        colonne3.add(Box.createHorizontalGlue()); // Ajouter de la "colle" horizontale pour étirer la liste
        colonne3.add(choixHeureLabel);
        colonne3.add(plageHoraireList);


        gbc.gridx=2;
        gbc.weightx=0;

        add(colonne3, gbc);


    }

    public void setController(ClientController clientController) {
        momentComboBox.addActionListener(clientController);
        mnbPersonnesComboBox.addActionListener(clientController);
        jourComboBox.addActionListener(clientController);
        nomReservationTextField.getDocument().addDocumentListener(clientController);
        plageHoraireList.addListSelectionListener(clientController);
        menuButton.addActionListener(clientController);
    }



}
