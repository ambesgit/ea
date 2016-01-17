
package cs544.amp2;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private int id;
    private String name;
   @OneToMany(mappedBy="department")   
    private List<Employee> employees=new ArrayList();

    public Department(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name=" + name + '}';
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    } 
    public void addEmployee(Employee e)
    {
        this.employees.add(e);
    
    }
    public void removeEmployee(Employee e)
    {
        this.employees.remove(e);
    
    }
    
}
