package Controller;

import Model.Profession;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
            ClientView clientView = new ClientView();
            ClientController clientController = new ClientController(clientView);
            clientView.setController(clientController);
            MainWindow mainWindow = new MainWindow(clientView, "Client");
            MainWindowController mainWindowController = new MainWindowController(mainWindow);
            mainWindow.setController(mainWindowController);
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
            loginWindow.Login();

        }
        else if (e.getSource()== loginWindow.cuistotButton)
        {
            System.out.println("Cuistot button pressed");
            status = Profession.Cuistot;
            loginWindow.Login();

        }
        else if (e.getSource()== loginWindow.barmanButton)
        {
            System.out.println("Barman button pressed");
            status = Profession.Barman;
            loginWindow.Login();

        }
        else if (e.getSource() == loginWindow.loginButton)
        {
            System.out.println("Login button pressed");
            CheckLogs();
        }
        else if(e.getSource() == loginWindow.adminButton)
        {
            System.out.println("Admin Button pressed");
            status = Profession.Admin;
            loginWindow.Login();
        }

    }

    private void CheckLogs()
    {

        if(status == Profession.Serveur)
        {
            try
            {
                Properties prop = new Properties();
                prop.load(new FileInputStream("PasswordsServeur.properties"));

                if (loginWindow.mdpTextField.getText().equals(prop.get(loginWindow.userTextField.getText())))
                {
                    System.out.println("Mot de passe correct");
                    loginWindow.dispose();
                    MainWindow mainWindow = new MainWindow(new ServeurMainView(), "Serveur");
                }
                else
                {
                    System.out.println("Mauvais mdp");
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("Erreur ! Fichier non trouve...");
            }
            catch(IOException e)
            {
                System.out.println("Erreur IO !");
            }
        }
        else if(status == Profession.Cuistot)
        {
            try
            {
                Properties prop = new Properties();
                prop.load(new FileInputStream("PasswordsCuisinier.properties"));

                if (loginWindow.mdpTextField.getText().equals(prop.get(loginWindow.userTextField.getText())))
                {
                    System.out.println("Mot de passe correct");
                    loginWindow.dispose();
                    MainWindow mainWindow = new MainWindow(new CuisinierView(), "Cuisinier");
                }
                else
                {
                    System.out.println("Mauvais mdp");

                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("Erreur ! Fichier non trouve...");
            }
            catch(IOException e)
            {
                System.out.println("Erreur IO !");
            }
        }
        else if(status == Profession.Barman)
        {
            try
            {
                Properties prop = new Properties();
                prop.load(new FileInputStream("PasswordsBarman.properties"));

                if (loginWindow.mdpTextField.getText().equals(prop.get(loginWindow.userTextField.getText())))
                {
                    System.out.println("Mot de passe correct");
                    loginWindow.dispose();
                    MainWindow mainWindow = new MainWindow(new BarmanView(), "Barman");
                }
                else
                {
                    System.out.println("Mauvais mdp");
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("Erreur ! Fichier non trouve...");
            }
            catch(IOException e)
            {
                System.out.println("Erreur IO !");
            }
        }

    }
}
