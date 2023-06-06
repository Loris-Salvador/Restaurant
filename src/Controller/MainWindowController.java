package Controller;

import View.LoginWindow;
import View.MainWindow;
import com.sun.tools.javac.Main;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindowController implements MenuListener {

    private MainWindow mainWindow;
    MainWindowController(MainWindow view)
    {
        mainWindow = view;
    }


    @Override
    public void menuSelected(MenuEvent e) {
        if(e.getSource() == mainWindow.menu)
        {
            mainWindow.dispose();
            LoginWindow loginWindow = new LoginWindow();
            LoginController loginController = new LoginController(loginWindow);

            loginWindow.setController(loginController);
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
