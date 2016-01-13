
package cs544.cmp1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Flight {
   private int id;
   private String from;
   private String to;
   private int flightNumber;
   private Date date;  
   private Passenger passenger;
    public Flight() {
    }

    public Flight(String from, String to, int flightNumber, Date date) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.flightNumber = flightNumber;
        this.date = date;
    }
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    @Column(name="departure")
    public String getFrom() {
        return from;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setFrom(String from) {
        this.from = from;
    }
    
    public void setTo(String to) {
        this.to = to;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name="destination")
    public String getTo() {
        return to;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public Date getDate() {
        return date;
    }
    
    @ManyToOne
    @JoinColumn(name="flight_id",updatable=false,insertable=false)
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
  
   
}
