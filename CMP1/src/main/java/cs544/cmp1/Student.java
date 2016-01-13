
package cs544.cmp1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
    private int id;
    private int studentId;
    private String firstname;
    private String lastName;
    private School school;
    public Student() {
    }

    public Student(int studentId, String firstname, String lastName) {        
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastName = lastName;
    }
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToOne
    @JoinColumn(name="school_id" ,updatable=false ,insertable=false)
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
    
}
