
package cs544.cxm1;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
    @Id
   @GeneratedValue
    private int id;
   
    private String appdate;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Patient")
    private Patient patient;
    @Embedded
    private Payment payment;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Doctor")
    private Doctor doctor;

    public Appointment() {
        
    }

    public Appointment(String appdate) {
        this.appdate = appdate;
    }
    

    public int getId() {
        return id;
    }

    public String getAppdate() {
        return appdate;
    }

    public Patient getPatient() {
        return patient;
    }

    public Payment getPayment() {
        return payment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    
}
