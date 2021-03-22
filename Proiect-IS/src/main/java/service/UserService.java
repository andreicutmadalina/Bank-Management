package service;

import dto.UserDto;
import entity.BankAccount;
import entity.Transactions;
import entity.User;
import exceptions.CustomExceptionMessages;
import exceptions.EntityNotExistsException;
import exceptions.InsufficientMoneyException;
import exceptions.WrongPasswordException;
import mappers.UserMapper;
import repository.BankAccountRepo;
import repository.TransactionsRepo;
import repository.UserRepo;
import validator.WithdrawValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {
    private UserRepo userRepo;
    private TransactionsRepo transactionsRepo;
    private BankAccountRepo bankAccountRepo;

    public UserService() {
        this.userRepo = new UserRepo();
        this.transactionsRepo = new TransactionsRepo();
        this.bankAccountRepo = new BankAccountRepo();
    }

    //gaseste user-ul dupa id: exemplu pentru login
    //te loghezi cu id-ul, deci cauti in baza de date user-ul cu acel id
    public UserDto getUser(String id, String password) {

        if (id == null || id.equals("")) {
            throw new IllegalArgumentException(CustomExceptionMessages.INVALID_ID_MESSAGE);
        }
        //string 36 de caractere (UUID).
        User user = userRepo.findUserById(id);
        if (user == null) {
            throw new EntityNotExistsException("No user having id " + id + " exists.");
        }
        System.out.println(user.getPassword());
        if(user.getPassword().equals(password) == false)
        {
            throw new IllegalArgumentException(WrongPasswordException.WRONG_PASSWORD);
        }
        UserDto userDto = UserMapper.entityToDto(user);
        return userDto;
    }

    public void depositMoney(BankAccount account, double amount) {
        double money = account.getBalance() + amount;
        bankAccountRepo.updateBalance(account, money);
        Transactions t = new Transactions(account, amount, "deposit", "add money");
        t.setIdTransaction(UUID.randomUUID().toString());
        transactionsRepo.insertNewTransactions(t);
    }

    public void withdrawMoney(BankAccount account, double amount) throws InsufficientMoneyException {
        WithdrawValidator.validateWithdraw(account, amount);
        double money = account.getBalance() - amount;
        bankAccountRepo.updateBalance(account, money);

        Transactions t = new Transactions(account, amount, "withdraw", "withdraw money");
        t.setIdTransaction(UUID.randomUUID().toString());

        transactionsRepo.insertNewTransactions(t);
    }

    public void transferMoney(BankAccount accountSender, BankAccount accountReceiver, double amount) throws InsufficientMoneyException {
        WithdrawValidator.validateWithdraw(accountSender, amount);

        String senderName = accountSender.getUser().getFirstName() + accountSender.getUser().getLastName();
        String receiverName = accountReceiver.getUser().getFirstName() + accountReceiver.getUser().getLastName();

        bankAccountRepo.updateBalance(accountSender, accountSender.getBalance() - amount);
        bankAccountRepo.updateBalance(accountReceiver, accountReceiver.getBalance() + amount);

        Transactions t1 = new Transactions(accountSender, amount, "send", "- " + amount + " to " + receiverName);
        t1.setIdTransaction(UUID.randomUUID().toString());

        Transactions t2 = new Transactions(accountReceiver, amount, "receive", "+ " + amount + " from " + senderName);
        t2.setIdTransaction(UUID.randomUUID().toString());

        transactionsRepo.insertNewTransactions(t1);
        transactionsRepo.insertNewTransactions(t2);
    }

    public void addUser(UserDto userDto) {
       /* UserValidator.validateAddNewUserFlow(userDto);

        user.setId(ApplicationUtils.generateUUID());

        userRepo.insertNewUser(user);*/
    }
    public String getFirstName(String id, String password) {

        if (id == null || id.equals("")) {
            throw new IllegalArgumentException(CustomExceptionMessages.INVALID_ID_MESSAGE);
        }
        //string 36 de caractere (UUID).
        User user = userRepo.findUserById(id);
        if (user == null) {
            throw new EntityNotExistsException("No user having id " + id + " exists.");
        }
        //System.out.println(user.getPassword());
        String name = user.getFirstName();
        return name;
    }

    public String getLastName(String id, String password) {

        if (id == null || id.equals("")) {
            throw new IllegalArgumentException(CustomExceptionMessages.INVALID_ID_MESSAGE);
        }
        //string 36 de caractere (UUID).
        User user = userRepo.findUserById(id);
        if (user == null) {
            throw new EntityNotExistsException("No user having id " + id + " exists.");
        }
        String name = user.getLastName();
        return name;
    }

    public String getEmail(String id, String password) {

        if (id == null || id.equals("")) {
            throw new IllegalArgumentException(CustomExceptionMessages.INVALID_ID_MESSAGE);
        }
        //string 36 de caractere (UUID).
        User user = userRepo.findUserById(id);
        if (user == null) {
            throw new EntityNotExistsException("No user having id " + id + " exists.");
        }
        //System.out.println(user.getPassword());
        String email = user.getEmail();
        return email;
    }

    public List<BankAccount> getUserBankAccount(String idUser){
        List<BankAccount> ba = bankAccountRepo.findAllBankAccountsForUser(idUser);
        return ba;
    }

    public List<String> getUserIDBankAccount(String idUser){
        List<String> ba = bankAccountRepo.findAllIdAccountForUser(idUser);
        return ba;
    }

    public List<String> getUserIDBankAccountwithMail(String mail){
        List<String> ba = bankAccountRepo.findAllIdAccountsForUserwithMail(mail);
        return ba;
    }

    public List<BankAccount> getUserBankAccountswithMail(String mail){
        List<BankAccount> ba = bankAccountRepo.findAllBankAccountsForUserwithMail(mail);
        return ba;
    }

    public BankAccount getAccountfromId(String id){
        BankAccount ba = bankAccountRepo.findBankAccountById(id);
        return ba;
    }

    public List<User> getAllUsersServ(){
        List<User> users = userRepo.findAllUsers();
        return users;
    }

    public List<String> getAllUsersIDServ(){
        List<User> users = userRepo.findAllUsers();
        List<String> ss = new ArrayList<String>();
        for (User u : users){
            ss.add(u.getIdUser());
        }
        return ss;
    }

    public List<String> getAllUsersNameServ(){
        List<String > s = userRepo.findAllUsersName();
        return s;
    }

    public List<BankAccount> getAccountsfromName(String name){
        List<BankAccount> ba = bankAccountRepo.findAllBankAccountsForUserName(name);
        return ba;
    }
    public List<String> getAccountsIDfromName(String name){
        List<BankAccount> ba = bankAccountRepo.findAllBankAccountsForUserName(name);
        List<String> ss = new ArrayList<String>();
        for(BankAccount b : ba){
            ss.add(b.getIdAccount());
        }
        return ss;
    }

    List<BankAccount> getAllBankAccounts(){
        List<BankAccount> ba = bankAccountRepo.findAllBankAccounts();
        return ba;
    }

    public List<String> getAllAccountsID(){
        List<BankAccount> ba = bankAccountRepo.findAllBankAccounts();
        List<String> ss = new ArrayList<String>();
        for(BankAccount b : ba){
            ss.add(b.getIdAccount());
        }
        return ss;
    }

    public List<BankAccount> findAllBankAccounts(String id)
    {
        List<BankAccount> bankAccounts = bankAccountRepo.findAllBankAccountsForUser(id);
        return bankAccounts;
    }

    /*public List<Transactions> getAllTransactionsForAccount(String id)
    {
        List<BankAccount> bankAccounts = bankAccountRepo.findAllBankAccountsForUser(id);
        List<Transactions> transactionsList= new ArrayList<Transactions>();
        for(BankAccount account : bankAccounts)
            for(Transactions transactions : account.getTransactions())
                transactionsList.add(transactions);
        return  transactionsList;
    }*/

    public List<String> getAllUsersEmail(){
        List<String> ss = userRepo.findAllUsersEmail();
        return ss;
    }

    public User getUserbyMail(String mail){
            User u1 =  userRepo.findUserbyMail(mail);
            return u1;
    }

    public User getUserbyEmail(String mail){
        User user =  userRepo.findUserEmail(mail);
        return user;
    }

    public User getUserbyId(String id){
        User us = userRepo.findUserById(id);
        return us;
    }

    public void updateUserPasswordServ(User user, String password){
        userRepo.updateUserPassword(user, password);
    }
}
