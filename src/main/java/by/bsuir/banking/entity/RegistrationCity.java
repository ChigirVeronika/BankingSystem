package by.bsuir.banking.entity;

/**
 * Created by Veranika_Chyhir on 9/5/2016.
 */
public class RegistrationCity {
    private Long id;
    private String name;

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
