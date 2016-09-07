package by.bsuir.banking.entity;

/**
 * Created by Veranika_Chyhir on 9/5/2016.
 */
public class Citizenship {
    private Long id;
    private String name;

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
