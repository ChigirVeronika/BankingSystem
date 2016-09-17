package by.bsuir.banking.entity;

import javax.persistence.*;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "number")
    private String number;
    @Column(name = "code")
    private String code;
    @Column(name = "active")
    private String active;
    @Column(name = "moneysum")
    private Long moneySum;

    @ManyToOne
    @JoinColumn(name = "deposit_id")
    private Deposit deposit;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Bill(String name, String number, String code, String active, Long moneySum) {
        this.name = name;
        this.number = number;
        this.code = code;
        this.active = active;
        this.moneySum = moneySum;
    }

    public Bill() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(Long moneySum) {
        this.moneySum = moneySum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }
}
