package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

import Model.Profession;
import View.ClientView;
import View.MainWindow;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class ClientController implements ActionListener, DocumentListener {

    private ClientView clientView;

    public ClientController(ClientView view)
    {
        clientView = view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clientView.momentComboBox) {
            clientView.nbPersonneLabel.setVisible(true);
            clientView.mnbPersonnesComboBox.setVisible(true);
        }
        else if (e.getSource() == clientView.mnbPersonnesComboBox)
        {
            clientView.jourLabel.setVisible(true);
            clientView.jourComboBox.setVisible(true);
        }
        else if(e.getSource() == clientView.jourComboBox)
        {
            clientView.nomReservationLabel.setVisible(true);
            clientView.nomReservationTextField.setVisible(true);
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
}
