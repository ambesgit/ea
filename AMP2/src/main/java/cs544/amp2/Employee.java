
package cs544.amp2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int empoyeenumber;
    private String name;
    @ManyToOne
    
    private Department department;
    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
    }

    public int getEmpoyeenumber() {
        return empoyeenumber;
    }

    public String getName() {
        return name;
    }

    public void setEmpoyeenumber(int empoyeenumber) {
        this.empoyeenumber = empoyeenumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" + "empoyeenumber=" + empoyeenumber + ", name=" + name + '}';
    }    
 
}
