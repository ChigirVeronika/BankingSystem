package by.bsuir.banking.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "citizenship")
public class Citizenship {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy="citizenship")
    @Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private User user;

    public Citizenship() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Citizenship(String name){
        this.name = name;
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

    @Override
    public String toString() {
        return "Citizenship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
