/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.amp2;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ambes
 */
@Entity
public class Book {
    @Id
    
    private int studentid;
    private String firstName;
    private String lastname;
    @ManyToOne
    private Publisher publisher;
    public Book(int studentid, String firstName, String lastname){
        this.studentid = studentid;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public Book() {
    }

    public int getStudentid() {
        return studentid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCourses(Publisher p) {
        this.publisher = p;
    }
    
    
}
