package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import View.ClientView;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ClientController implements ActionListener, DocumentListener, ListSelectionListener {

    private ClientView clientView;

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
