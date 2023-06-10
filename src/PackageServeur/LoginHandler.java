package PackageServeur;

import Messages.LoginRequest;
import Messages.Request;
import java.lang.Boolean;

import Model.Profession;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class LoginHandler implements Runnable {
    private final Socket clientSocket;
    private ObjectOutputStream out;
    private LoginRequest loginRequest;
    private Boolean result;

    public LoginHandler(Request loginRequest, Socket clientSocket, ObjectOutputStream out) {
//        this.loginRequest = lg;
        this.clientSocket = clientSocket;
        this.loginRequest = (LoginRequest) loginRequest;
//        try
//        {
            this.out = out;
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
    }
        @Override
        public void run() {
            try {
//                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
//                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());


                // Réception de l'objet envoyé par le client
//                LoginRequest loginRequest = (LoginRequest) in.readObject();
//                System.out.println("Objet reçu du client : " + loginRequest);

                // Traitement de la requête et génération du résultat (boolean)
                if(loginRequest.getProfession() == Profession.Serveur) {

                    try {
                        Properties prop = new Properties();
                        prop.load(new FileInputStream("PasswordsServeur.properties"));

                        if (loginRequest.getPassword().equals(prop.get(loginRequest.getUsername()))) {
                            result = true;
                        } else {
                            result=false;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Erreur ! Fichier non trouve...");
                    } catch (IOException e) {
                        System.out.println("Erreur IO !");
                    }
                }

                if(loginRequest.getProfession() == Profession.Cuistot) {

                    try {
                        Properties prop = new Properties();
                        prop.load(new FileInputStream("PasswordsCuisinier.properties"));

                        if (loginRequest.getPassword().equals(prop.get(loginRequest.getUsername()))) {
                            result = true;
                        } else {
                            result=false;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Erreur ! Fichier non trouve...");
                    } catch (IOException e) {
                        System.out.println("Erreur IO !");
                    }
                }

                if(loginRequest.getProfession() == Profession.Barman) {

                    try {
                        Properties prop = new Properties();
                        prop.load(new FileInputStream("PasswordsBarman.properties"));

                        if (loginRequest.getPassword().equals(prop.get(loginRequest.getUsername()))) {
                            result = true;
                        } else {
                            result=false;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Erreur ! Fichier non trouve...");
                    } catch (IOException e) {
                        System.out.println("Erreur IO !");
                    }
                }

                // Envoi du résultat au client
                out.writeObject(result);
                out.flush();
                System.out.println("Résultat envoyé au client : " + result);

            } catch (IOException e) {
                e.printStackTrace();
            }
//            catch (ClassNotFoundException ex)
//            {
//                ex.printStackTrace();
//            }
        }

}
