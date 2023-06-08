package Handlers;

import Messages.LoginRequest;

import java.io.*;
import java.net.Socket;

public class LoginHandler implements Runnable {
    private final Socket clientSocket;

    public LoginHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
        @Override
        public void run() {
            try {
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

                // Réception de l'objet envoyé par le client
                LoginRequest loginRequest = (LoginRequest) in.readObject();
                System.out.println("Objet reçu du client : " + loginRequest);

                // Traitement de la requête et génération du résultat (boolean)
                boolean result = true; // Votre logique de traitement ici

                // Envoi du résultat au client
                out.writeObject(result);
                out.flush();
                System.out.println("Résultat envoyé au client : " + result);

                // Fermeture des flux et de la connexion avec le serveur
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

}
