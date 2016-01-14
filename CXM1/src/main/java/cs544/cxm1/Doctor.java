
package cs544.cxm1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Doctor {
    @Id
    @GeneratedValue
    private int id;
    @Column(name="type")
    private String doctorType;    
    private String firstName;    
    private String lastName;

    public Doctor(String doctorType, String firstName, String lastName) {        
        this.doctorType = doctorType;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Doctor() {
    }

    public int getId() {
        return id;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
