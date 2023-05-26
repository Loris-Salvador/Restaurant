import Controller.LoginController;
import View.LoginWindow;

public class Main {
    public static void main(String[] args)
    {
        LoginWindow loginWindow = new LoginWindow();
        LoginController loginController = new LoginController(loginWindow);

        loginWindow.setController(loginController);
    }
}