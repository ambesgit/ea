
package cs544.cmp1;


import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Set<Laptop> laptops;
    public Employee() {
    }

    public Employee(String firstName, String lastName) {       
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    @OneToMany(mappedBy="owner",cascade=CascadeType.ALL)
    
    public Set<Laptop> getLaptops() {
        return laptops;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLaptops(Set<Laptop>laptops) {
        this.laptops=laptops;
    }
    
}
