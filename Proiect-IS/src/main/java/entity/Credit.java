package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "credit")
public class Credit {

    @Id
    private String idCredit;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @Column
    private double interestRate; //dobanda

    @Column
    private double rate; //rata

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private double loan;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idAccount")
    private BankAccount account;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idGuarantee")
    private Guarantee guarantee;

    public Credit(User user,BankAccount account, double interestRate,  Date endDate, double loan, Guarantee guarantee)
    {
        this.user = user;
        this.account = account;
        this.interestRate = interestRate;
        this.endDate = endDate;
        this.loan = loan;
        this.guarantee = guarantee;
        startDate =  new Date();
    }

    public Credit()
    {

    }

    public Guarantee getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Guarantee idGuarantee) {
        this.guarantee = idGuarantee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public String getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(String idCredit) {
        this.idCredit = idCredit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "idCredit='" + idCredit + '\'' +
                ", user=" + user +
                ", interestRate=" + interestRate +
                ", rate=" + rate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", loan=" + loan +
                ", account=" + account +
                ", guarantee=" + guarantee +
                '}';
    }
}
