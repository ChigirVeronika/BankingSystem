package by.bsuir.banking.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "disability")
public class Disability {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;

    @OneToOne(mappedBy="disability")
    @Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private User user;

    public Disability() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Disability(String type){
        this.type=type;
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

    @Override
    public String toString() {
        return "Disability{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
