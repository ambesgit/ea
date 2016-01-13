
package cs544.cmp1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;

@Entity
public class Passenger {
    private int id;
    private String name;
    private List<Flight> flights=new ArrayList();;

    public Passenger() {
    }

    public Passenger(String name) {        
        this.name = name;
    }
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="flight_id")
    public List<Flight> getFlight() {
        return flights;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlight(List<Flight> flight) {
        this.flights=flight;
    }
    

    
}
