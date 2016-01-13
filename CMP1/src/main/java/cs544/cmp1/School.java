
package cs544.cmp1;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class School {
    private int id;
    private String name;
    private Map<Integer,Student> students;

    public School() {
    }

    public School(String name) {
        
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
    @JoinColumn(name="school_id")
    @MapKey(name="studentId")
    public Map<Integer, Student> getStudents() {
        return students;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(Map<Integer, Student> students) {
        this.students = students;
    }
    
}
