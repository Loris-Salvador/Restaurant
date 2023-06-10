package Controller;

import Messages.LoginRequest;
import Messages.TypeRequete;
import View.*;
import Model.*;
import java.lang.Boolean;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.rmi.UnknownHostException;
import java.util.Properties;
import java.io.IOException;
import java.net.Socket;

public class LoginController implements ActionListener {

    private LoginWindow loginWindow;
    private Profession status;
    private final String serverAddress = "localhost";
    private final int serverPort = 8080;
    Boolean response;


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
            System.out.println("PackageServeur.Serveur button pressed");
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
        try
        {

            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println(socket);

        // Obtention des flux d'entrée/sortie pour la communication avec le serveur

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());



            System.out.println("njdsnsfn");


        if(status == Profession.Serveur)
        {

                // Création de l'objet LoginRequest à envoyer
                LoginRequest request = new LoginRequest(loginWindow.userTextField.getText(), loginWindow.mdpTextField.getText(), status, TypeRequete.Login);
                System.out.println("Requete cote client : " + request);
                // Envoi de l'objet au serveur
                out.writeObject(request);
                out.flush();
                System.out.println("Requête envoyée au serveur : " + request);

                // Lecture de la réponse du serveur
// Lecture de la réponse du serveur
// Lecture de la réponse du serveur

            try {
                response = (Boolean) in.readObject();
                System.out.println("Réponse reçue du serveur : " + response);
            } catch (ClassNotFoundException e) {
                System.out.println("Erreur lors de la lecture de l'objet : " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Erreur d'entrée/sortie : " + e.getMessage());
            }



                if(response)
                {
                    loginWindow.dispose();
                    ServeurMainView serveurMainView = new ServeurMainView();
                    ServeurController serveurController = new ServeurController(serveurMainView);
                    serveurMainView.setController(serveurController);
                    MainWindow mainWindow = new MainWindow(serveurMainView, "Serveur");
                    MainWindowController mainWindowController = new MainWindowController(mainWindow);
                    mainWindow.setController(mainWindowController);
                }
                else
                {
                    System.out.println("MDP incorrect");
                }

        }
        else if(status == Profession.Cuistot)
        {
            // Création de l'objet LoginRequest à envoyer
            LoginRequest request = new LoginRequest(loginWindow.userTextField.getText(), loginWindow.mdpTextField.getText(), status, TypeRequete.Login);
            System.out.println("Requete cote client : " + request);
            // Envoi de l'objet au serveur
            out.writeObject(request);
            out.flush();
            System.out.println("Requête envoyée au serveur : " + request);

            // Lecture de la réponse du serveur
            Boolean response = (Boolean) in.readObject();
            System.out.println("Réponse reçue du serveur : " + response);

            if(response)
            {

                loginWindow.dispose();
                MainWindow mainWindow = new MainWindow(new CuisinierView(), "Cuisinier");
                MainWindowController mainWindowController = new MainWindowController(mainWindow);
                mainWindow.setController(mainWindowController);
            }
            else {
                System.out.println("MDP incorrect");
            }

        }
        else if(status == Profession.Barman)
        {
            // Création de l'objet LoginRequest à envoyer
            LoginRequest request = new LoginRequest(loginWindow.userTextField.getText(), loginWindow.mdpTextField.getText(), status, TypeRequete.Login);
            System.out.println("Requete cote client : " + request);
            // Envoi de l'objet au serveur
            out.writeObject(request);
            out.flush();
            System.out.println("Requête envoyée au serveur : " + request);

            // Lecture de la réponse du serveur
            boolean response = (boolean) in.readObject();
            System.out.println("Réponse reçue du serveur : " + response);

            if(response)
            {
                loginWindow.dispose();
                MainWindow mainWindow = new MainWindow(new BarmanView(), "Barman");
                MainWindowController mainWindowController = new MainWindowController(mainWindow);
                mainWindow.setController(mainWindowController);
            }
            else {
                System.out.println("MDP incorrect");
            }
        }
            out.close();
            in.close();
            socket.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
