package PackageServeur;

import Messages.LoginRequest;
import Messages.Request;
import Messages.TypeRequete;
import Model.Categorie;
import Model.MenuItem;
import Model.Plat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;


public class Serveur implements Runnable {

    public ArrayList<MenuItem> menu = new ArrayList<>();

    public Serveur()
    {

    }
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
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

//                 Réception de l'objet envoyé par le client
                Request Request = (Request) in.readObject();
//                out.writeObject(true);
//                out.flush();

//                 Créer un thread pour gérer la connexion client
                if(Request.getType().equals(TypeRequete.Login))
                {
                    LoginHandler loginHandler = new LoginHandler(Request, clientSocket, out);
                    Thread thread = new Thread(loginHandler);
                    thread.start();
                }
                else if(Request.getType().equals(TypeRequete.Menu))
                {
//                    PrintWriter outMenu = new PrintWriter(clientSocket.getOutputStream(), true);
                    String filePath = "Menu.csv";

                    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            out.writeObject(line);
                            out.flush();
                        }
                        out.writeObject("FinMenu");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

}
