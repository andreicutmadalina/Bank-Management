package controller;

import Reports.Report;
import entity.BankAccount;
import entity.Transactions;
import entity.User;
import exceptions.InsufficientMoneyException;
import service.UserService;
import view.LoginView;
import view.UserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    private final UserService userService = new UserService();
    private UserView view;
    private LoginView log;
    private String username;
    private String password;

    public UserController(UserView view, LoginView log)
    {
        this.view = view;
        this.log = log;

        view.createSelectAccountComboBox(view.getEmailLogin());
        view.createSenderComboBox(view.getEmailLogin());
        view.createWithdrawComboBox(view.getEmailLogin());
        view.createTable((ArrayList)userService.getUserBankAccountswithMail(view.getEmailLogin()));

        username = log.getEmailText();
        password = log.getPasswordText();
        view.setInsertEmailLabel(userService.getEmail(username, password));
        view.setInsertFirstNameLabel(userService.getFirstName(username, password));
        view.setInsertLastNameLabel(userService.getLastName(username, password));

        this.view.addConfirmButtonListener(new ConfirmButtonListener());
        this.view.addTransferButtonListener(new TransferButtonListener());
        this.view.addWithdrawButtonListener(new WidrawButtonListener());
        this.view.addAuxiliarButtonListener(new AuxiliarButtonListener());
        this.view.addChangePasswordListener(new ChangeButtonListener());
        this.view.addReportButtonListener(new ReportButtonListener());
    }

    class ReportButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<BankAccount> bankAccounts = userService.findAllBankAccounts(username);
            Report transactionsReport = new Report( userService.getFirstName(username, password) + ".pdf", bankAccounts);
        }
    }

    class ChangeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                String emailUser = view.getEmailLogin();
                User u = userService.getUserbyId(log.getEmailText());
                String password = view.getNewPassword();
                userService.updateUserPasswordServ(u, password);
        }
    }

    class AuxiliarButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String receiver = view.getReceiverComboBox();
                view.createReceiverAccountComboBox(receiver);
            } catch (Exception ex) {
                System.err.println("ERROR ON CONFIRM RECEIVER!");
            }
        }
    }

class WidrawButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        try {
            double q = view.getAmountWithdrawLabel();
            BankAccount ba = view.getSelectWithdrawComboBox();
            userService.withdrawMoney(ba, q);
        } catch (ArrayIndexOutOfBoundsException | InsufficientMoneyException ex) {
            System.err.println("ERROR ON WITHDRAW MONEY!");
        }
    }
}


class ConfirmButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        try {
            double q = view.getAmountLabel();
            BankAccount ba = view.getSelectAccountComboBox();
            userService.depositMoney(ba, q);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("ERROR ON DEPOSIT MONEY!");
        }
    }
}

class TransferButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        try {
            double q = view.getAmountTransferLabel();
            BankAccount sender = view.getSenderComboBox();
            BankAccount receiver = view.getReceiverAccComboBox();
            userService.transferMoney(sender, receiver, q);
        } catch (ArrayIndexOutOfBoundsException | InsufficientMoneyException ex) {
            System.err.println("ERROR ON TRANSFER MONEY!");
        }
    }
}

}
