package Controller;

import View.LoginWindow;
import View.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    private LoginWindow loginWindow;
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
            //MainWindow mainWindow = new MainWindow();
        }
        else if (e.getSource() == loginWindow.personnelButton)
        {
            System.out.println("Personnel Button pressed");
        }

    }
}
