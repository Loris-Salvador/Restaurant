package Controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;
import Model.*;

import Messages.LoginRequest;
import Messages.TypeRequete;
import Model.MenuItem;
import View.ClientView;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Messages.*;


public class ClientController implements ActionListener, DocumentListener, ListSelectionListener {

    private ClientView clientView;
    private final String serverAddress = "localhost";
    private final int serverPort = 8080;
    private ArrayList<MenuItem> menu = new ArrayList<>();

    public ClientController(ClientView view)
    {
        clientView = view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clientView.momentComboBox) {
            if(clientView.momentComboBox.getSelectedIndex()!=0)
            {
                clientView.nbPersonneLabel.setVisible(true);
                clientView.mnbPersonnesComboBox.setVisible(true);
            }

        }
        else if (e.getSource() == clientView.mnbPersonnesComboBox)
        {
            if(clientView.mnbPersonnesComboBox.getSelectedIndex() != 0)
            {
                clientView.jourLabel.setVisible(true);
                clientView.jourComboBox.setVisible(true);
            }

        }
        else if(e.getSource() == clientView.jourComboBox)
        {
            if(clientView.jourComboBox.getSelectedIndex() != 0)
            {
                //afficher item liste
                String[] elements = {"19 h 30   -   20 h 30", "20 h 30   -   21 h 30"};
                clientView.plageHoraireList.setListData(elements);
                if (clientView.plageHoraireList.getModel().getSize() == 0)
                {
                    clientView.plusDePlaceLabel.setVisible(true);
                }
            }
        }
        else if(e.getSource() == clientView.menuButton)
        {
            try {
                Socket socket = new Socket(serverAddress, serverPort);
                System.out.println(socket);

                // Obtention des flux d'entrée/sortie pour la communication avec le serveur
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());


                Request request = new Request(TypeRequete.Menu);
                out.writeObject(request);
                out.flush();



                String ligneMenu = (String) in.readObject();
                while (!ligneMenu.equals("FinMenu"))
                {
                    System.out.println("ligne menu" + ligneMenu);

                    String[] values = ligneMenu.split(";");
                    if(values.length > 2)
                    {
                        if(values[2].equals("PLAT"))
                        {
                            menu.add(new Plat(Categorie.PLAT,Double.parseDouble(values[0]), values[1]));
                        }
                        else if(values[2].equals("ENTREE"))
                        {
                            menu.add(new Plat(Categorie.ENTREE,Double.parseDouble(values[0]), values[1]));
                        }
                        else if(values[2].equals("DESSERT"))
                        {
                            menu.add(new Plat(Categorie.DESSERT,Double.parseDouble(values[0]), values[1]));
                        }
                    }
                    else
                    {
                        menu.add(new Boisson(Double.parseDouble(values[0]), values[1]));
                    }

                    ligneMenu = (String) in.readObject();

                }
                System.out.println("Menu Client : " + menu);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
            catch (ClassNotFoundException ef) {
                System.out.println("Erreur lors de la lecture de l'objet : " + ef.getMessage());
            }



        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (e.getDocument().equals(clientView.nomReservationTextField.getDocument())) {
            clientView.reserverButton.setVisible(true);
        }
    }


    @Override
    public void removeUpdate(DocumentEvent e) {
        if (e.getDocument().equals(clientView.nomReservationTextField.getDocument())) {
            if(Objects.equals(clientView.nomReservationTextField.getText(), "")) {
                clientView.reserverButton.setVisible(false);
            }
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource() == clientView.plageHoraireList)
        {
            clientView.nomReservationLabel.setVisible(true);
            clientView.nomReservationTextField.setVisible(true);
        }
    }
}
