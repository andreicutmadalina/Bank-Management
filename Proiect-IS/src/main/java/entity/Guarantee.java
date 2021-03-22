package entity;

import javax.persistence.*;

@Entity
@Table(name = "guarantee")
public class Guarantee {

    @Id
    private String idGuarantee;

    @OneToOne(mappedBy = "guarantee", fetch = FetchType.LAZY)
    private Credit credit;

    @Column
    private String jobName;

    @Column
    private double salaryPerMonth;

    @Column
    private double wealth; //avere

    public Guarantee(String jobName, double salaryPerMonth, double wealth)
    {
        this.jobName = jobName;
        this.salaryPerMonth = salaryPerMonth;
        this.wealth = wealth;
    }

    public Guarantee()
    {

    }

    public String getIdGuarantee() {
        return idGuarantee;
    }

    public void setIdGuarantee(String idGuarantee) {
        this.idGuarantee = idGuarantee;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public double getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(double salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

    public double getWealth() {
        return wealth;
    }

    public void setWealth(double wealth) {
        this.wealth = wealth;
    }
}
