package controller;

import dto.AdminDto;
import dto.UserDto;
import service.AdminService;
import service.UserService;
import utils.ControllerUtils;
import view.LoginView;
import view.UserView;
import view.adminView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private final UserService userService = new UserService();
    private final AdminService adminService = new AdminService();
    private LoginView view;

    public LoginController(LoginView view)
    {
        this.view = view;
        view.buttonListener(new login());
        view.buttonListenerAdmin(new loginAdmin());
    }

    class login implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String username = view.getEmailText();
                String password = view.getPasswordText();
                UserDto user =  userService.getUser(username, password);
                System.out.println(user);
                String emailLogin = userService.getEmail(username, password);
                System.out.println("EMAIL AICI: " +  emailLogin);
                new UserController(new UserView(emailLogin), view);
                view.setVisible(false);
            } catch (Exception ex) {
                ControllerUtils.createSwingErrorMessage(ex.getMessage());
            }
        }
    }

    class loginAdmin implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String username = view.getEmailText();
                String password = view.getPasswordText();
                AdminDto admin =  adminService.getAdmin(username, password);
                System.out.println(admin);
                new AdminController(new adminView());
                view.setVisible(false);
            } catch (Exception ex) {
                ControllerUtils.createSwingErrorMessage(ex.getMessage());
            }
        }
    }



}
