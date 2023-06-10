import Controller.LoginController;
import PackageServeur.Serveur;
import View.LoginWindow;

public class Main {
    public static void main(String[] args) {
        // Création de l'objet serveur
        Serveur serveur = new Serveur();

        // Création et démarrage du thread du serveur
        Thread serveurThread = new Thread(serveur);
        serveurThread.start();

        // Création de la fenêtre de connexion
        LoginWindow loginWindow = new LoginWindow();
        LoginController loginController = new LoginController(loginWindow);
        loginWindow.setController(loginController);

    }
}
