package by.bsuir.banking.entity;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "deposit")
public class Deposit {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;
    @Column(name = "agreementnumber")
    private Integer agreementNumber;
    @Column(name = "money")
    private String money;

    @Column(name = "startdate")
    private Date startDate;
    @Future
    @Column(name = "enddate")
    private Date endDate;
    @Column(name = "moneysum")
    private Long moneySum;
    @Column(name = "percent")
    private Integer percent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "deposit")
    private Set<Bill> bills;

    public Deposit(){}
    public Deposit(Long moneySum){
        this.moneySum = moneySum;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", agreementNumber=" + agreementNumber +
                ", money='" + money + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", moneySum=" + moneySum +
                ", percent=" + percent +
                ", creator=" + creator +
                ", bills=" + bills +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAgreementNumber() {
        return agreementNumber;
    }

    public void setAgreementNumber(Integer agreementNumber) {
        this.agreementNumber = agreementNumber;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
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

    public Long getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(Long moneySum) {
        this.moneySum = moneySum;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }
}
