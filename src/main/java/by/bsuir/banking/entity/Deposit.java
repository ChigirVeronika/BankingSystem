package by.bsuir.banking.entity;

import javax.persistence.*;
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
    private Integer agreementnumber;
    @Column(name = "money")
    private String money;
    @Column(name = "startdate")
    private Date startdate;
    @Column(name = "enddate")
    private Date enddate;
    @Column(name = "moneysum")
    private Long moneysum;
    @Column(name = "percent")
    private Integer percent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "deposit")
    private Set<Bill> bills;

    public Deposit(){}
    public Deposit(Long moneysum){
        this.moneysum = moneysum;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
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

    public Integer getAgreementnumber() {
        return agreementnumber;
    }

    public void setAgreementnumber(Integer agreementnumber) {
        this.agreementnumber = agreementnumber;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Long getMoneysum() {
        return moneysum;
    }

    public void setMoneysum(Long moneysum) {
        this.moneysum = moneysum;
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

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", agreementnumber=" + agreementnumber +
                ", money='" + money + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", moneysum=" + moneysum +
                ", percent=" + percent +
                ", creator=" + creator +
                '}';
    }
}
