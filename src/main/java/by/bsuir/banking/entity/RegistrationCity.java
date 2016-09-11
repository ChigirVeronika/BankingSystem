package by.bsuir.banking.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "registrationcity")
public class RegistrationCity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy="registrationCity")
    @Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private User user;

    public RegistrationCity() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RegistrationCity(String name){
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
        return "RegistrationCity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
