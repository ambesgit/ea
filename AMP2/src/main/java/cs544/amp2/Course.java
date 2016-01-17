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
import javax.persistence.ManyToMany;


/**
 *
 * @author ambes
 */
@Entity
public class Course {
    @Id
    
    private int id;
    private String courseNumber;
    private String name;
    @ManyToMany
    private List<Student> students=new ArrayList();
    public Course(String courseNumber, String name) {
        
        this.courseNumber = courseNumber;
        this.name = name;
    }

    public Course() {
    }
    
    
}
