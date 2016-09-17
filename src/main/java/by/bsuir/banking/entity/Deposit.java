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

    @Column(name = "enddate")
    private Date endDate;

    @Column(name = "name")
    private String name;

    @Column(name = "percent")
    private Integer percent;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "deposit")
    private Set<Bill> bills;

    public Deposit(){}

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", agreementNumber=" + agreementNumber +
                ", money='" + money + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", percent=" + percent +
                ", bills=" + bills +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }
}
