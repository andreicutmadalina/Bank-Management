package controller;

import entity.*;
import service.AdminService;
import view.adminView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class AdminController {
    private  AdminService adminService = new AdminService();
    private adminView view;

    public AdminController(adminView view)
    {
        this.view = view;
        this.view.addUserButtonListener(new addButtonListener());
        this.view.deleteUserButtonListener(new deleteButtonListener());
        this.view.addAccountButtonListener(new addAccountListener());
        this.view.Button1Listener(new addButton1Listener());
        this.view.Button2Listener(new addButton2Listener());
    }

    class addButton2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User userCredit = view.getUserComboBox3Selected();
            BankAccount accCredit = view.getAccountComboBox4Selected();

            double Irate = view.getInterestRate();
            double creditAmount = view.getCreditAmount();
            String dateEnd = view.getEndDate();
            String job = view.getJob();
            double salary = view.getSalary();
            double wealth = view.getWealth();
            Guarantee guarantee = new Guarantee(job, salary, wealth);

            Date date  = null;
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(dateEnd);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            guarantee.setIdGuarantee(UUID.randomUUID().toString());

            System.out.println(userCredit.getFirstName()+ accCredit.getBalance() +" irate " + Irate + "creditamount "+ creditAmount);

            //adminService.addGuarantee(g);
            Credit creditNew = new Credit(userCredit, accCredit, Irate, date, creditAmount , guarantee);
            System.out.println("AICI AVEM NOUL CREDIT: " + creditNew);
            adminService.addCredit(creditNew);
        }
    }

    class addButton1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = view.getUserComboBox1Selected();
            BankAccount acc = view.getAccountComboBox2Selected();
            adminService.deleteAccServ(acc);
        }
    }

    class deleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                User user = view.getSelectDELETEComboBox();
                adminService.deleteUserServ(user);
        }
    }

    class addAccountListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            User user = view.getuserCreateAccountSelected();
            String idUser = user.getIdUser();
            String type = view.getAccountTypeSelected();
            Double balance = view.getBalanceText();
            BankAccount account =  new BankAccount(type, user, balance);
            adminService.addBankAccount(account);
        }
    }


    class addButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                String first = view.getFirstNameAddText();
                String last = view.getLastNameAddText();
                String cnp = view.getCnpAddText();
                String email = view.getEmailAddText();
                String phone =  view.getPhoneAddText();
                String birthdate = view.getBirthdateAddText();
                String country = view.getCountryAddText();
                String city = view.getCityAddText();
                String street = view.getStreetAddText();
                int no = view.getNumberAddText();
                 Date date  = null;
                 try {
                     date = new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);
                     } catch (ParseException ex) {
                      ex.printStackTrace();
                 }
                 Address adr = new Address(country, city, street, no);
                 adr.setIdAddress(UUID.randomUUID().toString());
                 User userNew = new User(first, last, cnp, adr, date, email, "user*");
                 adminService.addUser(userNew);
        }
    }

}
