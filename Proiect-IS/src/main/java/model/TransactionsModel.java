package model;

import entity.BankAccount;
import entity.Transactions;
import exceptions.InsufficientMoneyException;
import repository.BankAccountRepo;
import repository.TransactionsRepo;
import repository.UserRepo;
import validator.WithdrawValidator;

import java.util.UUID;


public class TransactionsModel {

    private TransactionsRepo tr;
    private BankAccountRepo br;
    private UserRepo ur;

    public TransactionsModel( UserRepo ur, TransactionsRepo tr, BankAccountRepo br) {
        this.tr = tr;
        this.br = br;
        this.ur = ur;
    }

    public void depositMoney(BankAccount account, double amount) {
        double money = account.getBalance() + amount;
        br.updateBalance(account, money);

        Transactions t = new Transactions(account, amount, "deposit", "add money");
        t.setIdTransaction(UUID.randomUUID().toString());

        tr.insertNewTransactions(t);
    }

    public void withdrawMoney(BankAccount account, double amount) throws InsufficientMoneyException {
        WithdrawValidator.validateWithdraw(account, amount);
        double money = account.getBalance() - amount;
        br.updateBalance(account, money);

        Transactions t = new Transactions(account, amount, "withdraw", "withdraw money");
        t.setIdTransaction(UUID.randomUUID().toString());

        tr.insertNewTransactions(t);
    }

    public void transferMoney(BankAccount accountSender, BankAccount accountReceiver, double amount) throws InsufficientMoneyException {
        WithdrawValidator.validateWithdraw(accountSender, amount);

        String senderName = accountSender.getUser().getFirstName() + accountSender.getUser().getLastName();
        String receiverName = accountReceiver.getUser().getFirstName() + accountReceiver.getUser().getLastName();

        br.updateBalance(accountSender, accountSender.getBalance() - amount);
        br.updateBalance(accountReceiver, accountReceiver.getBalance() + amount);

        Transactions t1 = new Transactions(accountSender, amount, "send", "- " + amount + " to " + receiverName);
        t1.setIdTransaction(UUID.randomUUID().toString());

        Transactions t2 = new Transactions(accountReceiver, amount, "receive", "+ " + amount + " from " + senderName);
        t2.setIdTransaction(UUID.randomUUID().toString());

        tr.insertNewTransactions(t1);
        tr.insertNewTransactions(t2);
    }



}
