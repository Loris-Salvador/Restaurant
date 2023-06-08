import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import Handlers.*;
public class Serveur implements Runnable {
    @Override
    public void run() {
        int port = 8080; // Port sur lequel le serveur écoute les connexions

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Le serveur est en attente de connexions sur le port " + port);

            while (true) {
                // Attendre une connexion client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouvelle connexion client : " + clientSocket);

                // Créer un thread pour gérer la connexion client
                LoginHandler loginHandler = new LoginHandler(clientSocket);
                Thread thread = new Thread(loginHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
