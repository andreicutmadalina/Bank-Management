package entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BankAccount")
public class BankAccount {

    @Id
    private String idAccount;

    @Column
    private String accountType;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account", fetch = FetchType.LAZY)
    private List<Transactions> transactions = new ArrayList<Transactions>();

    @Column
    private Date dateOpened;

    @Column
    private Date dateClosed;

    @Column
    private boolean activeStatus;

    @Column
    private double balance;

    @OneToOne(mappedBy = "account")
    private Credit credit;

    public BankAccount(String accountType, User user, double balance)
    {
        this.accountType = accountType;
        this.user = user;
        this.balance = balance;
        this.dateOpened = new Date();
        this.activeStatus = true;
    }

    public BankAccount(){}

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Date getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = dateClosed;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "idAccount='" + idAccount + '\'' +
                ", accountType='" + accountType + '\'' +
                ", user=" + user +
                ", transactions=" + transactions +
                ", dateOpened=" + dateOpened +
                ", dateClosed=" + dateClosed +
                ", activeStatus=" + activeStatus +
                ", balance=" + balance +
                '}';
    }
}
