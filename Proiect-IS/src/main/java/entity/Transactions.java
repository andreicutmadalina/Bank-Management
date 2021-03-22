package entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Transactions")
public class Transactions {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String idTransaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAccount")
    private BankAccount account;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "name", length = 100 ,nullable = false)
    private String description;

    @Column(name = "type", length = 100, nullable = false)
    private String type;

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public Transactions(BankAccount account, double amount, String type, String description)
    {
        this.account= account;
        this.amount = amount;
        this.date = new Date();
        this.type = type;
        this.description = description;
    }

    public Transactions()
    {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public BankAccount getIdAccount() {
        return account;
    }

    public void setIdAccount(BankAccount idAccount) {
        this.account = idAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "idTransaction='" + idTransaction + '\'' +
                ", account=" + account.getBalance() +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
