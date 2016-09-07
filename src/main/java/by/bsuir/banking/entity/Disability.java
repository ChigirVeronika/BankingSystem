package by.bsuir.banking.entity;

/**
 * Created by Veranika_Chyhir on 9/5/2016.
 */
public class Disability {
    private Long id;
    private String type;

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
