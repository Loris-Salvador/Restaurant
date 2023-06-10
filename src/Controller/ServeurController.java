package Controller;

import PackageServeur.Serveur;
import View.ServeurMainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ServeurController implements ActionListener {
    private ServeurMainView serveurMainView;

    public ServeurController(ServeurMainView serveurMainView)
    {
        this.serveurMainView = serveurMainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("test");

        if(e.getSource() == serveurMainView.categorieComboBox)
        {
            System.out.println("dsffdsf");
            if(serveurMainView.categorieComboBox.getSelectedIndex() == 3)
            {
                System.out.println("c'est un Dessert");
            }
        }
    }
}
