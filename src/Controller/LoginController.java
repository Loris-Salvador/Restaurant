package Controller;

import Model.Profession;
import View.ClientView;
import View.LoginWindow;
import View.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    private LoginWindow loginWindow;
    private Profession status;

    public LoginController(LoginWindow logWindow)
    {
        loginWindow = logWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == loginWindow.clientButton)
        {
            System.out.println("client Button pressed");
            loginWindow.dispose();
            MainWindow mainWindow = new MainWindow(new ClientView(), "Client");
        }
        else if (e.getSource() == loginWindow.personnelButton)
        {
            System.out.println("Personnel Button pressed");
            loginWindow.Personnel();
        }
        else if (e.getSource()== loginWindow.serveurButton)
        {
            System.out.println("Serveur button pressed");
            status = Profession.Serveur;
        }
        else if (e.getSource()== loginWindow.cuistotButton)
        {
            System.out.println("Cuistot button pressed");
            status = Profession.Cuistot;
        }
        else if (e.getSource()== loginWindow.barmanButton)
        {
            System.out.println("Barman button pressed");
            status = Profession.Barman;
        }

    }
}
