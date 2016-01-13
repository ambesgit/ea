
package cs544.cmp1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Laptop {
    private int id;
    private String brand;
    private String type;
    private Employee owner;
    public Laptop() {
    }

    public Laptop(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }
    @ManyToOne
    public Employee getOwner() {
        return owner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }
    
}
