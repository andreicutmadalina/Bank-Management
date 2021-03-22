package start;

import controller.LoginController;
import exceptions.InsufficientMoneyException;
import view.LoginView;


public class ApplicationStart {
    public static void main(String[] args) throws InsufficientMoneyException {
        LoginView loginView = new LoginView();
        loginView.setVisible(true);

        LoginController loginController = new LoginController(loginView);
        for(;;){
            if (!loginView.isDisplayable())
                break;
        }
    }
}
