
package cs544.hpa1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Owner {
   
    private int id;
    private String name;
    private String address;
    public Owner(String name, String address) {      
        this.name = name;
        this.address = address;
    }

    public Owner() {
    }
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Owner{" + "id=" + id + ", name=" + name + ", address=" + address + '}';
    }
    
}
