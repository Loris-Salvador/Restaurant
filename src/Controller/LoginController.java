package Controller;

import Messages.LoginRequest;
import View.*;
import Model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;
import java.io.IOException;
import java.net.Socket;

public class LoginController implements ActionListener {

    private LoginWindow loginWindow;
    private Profession status;
    private final String serverAddress = "localhost";
    private final int serverPort = 8080;


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
            //
            try {
                Socket socket = new Socket(serverAddress, serverPort);
                System.out.println("YO");
                // Obtention des flux d'entrée/sortie pour la communication avec le serveur
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                // Création de l'objet LoginRequest à envoyer
                LoginRequest request = new LoginRequest(loginWindow.userTextField.getText(), loginWindow.mdpTextField.getText(), status);
                System.out.println("Requete cote client : " + request);
                // Envoi de l'objet au serveur
                out.writeObject(request);
                out.flush();
                System.out.println("Requête envoyée au serveur : " + request);

                // Lecture de la réponse du serveur
                Boolean response = (Boolean) in.readObject();
                System.out.println("Réponse reçue du serveur : " + response);

                // Fermeture des flux et de la connexion avec le serveur
                out.close();
                in.close();
                socket.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
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
                    MainWindowController mainWindowController = new MainWindowController(mainWindow);
                    mainWindow.setController(mainWindowController);
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
                    MainWindowController mainWindowController = new MainWindowController(mainWindow);
                    mainWindow.setController(mainWindowController);
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
