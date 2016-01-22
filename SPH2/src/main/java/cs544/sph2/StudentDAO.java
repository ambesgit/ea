package cs544.sph2;


import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentDAO {
        private SessionFactory sf;
	private static Collection<Student> studentlist = new ArrayList<Student>();
        public StudentDAO(SessionFactory fs){
            this.sf=sf;
        }
     
	public void init(){            
           
		Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);
		studentlist.add(student); //this was used with the array so no important now
                sf.getCurrentSession().saveOrUpdate(student);
                

	}	
        
        public Student get(long id){
            return (Student)sf.getCurrentSession().get(Student.class, id);
        }
        public void create(Student st){
         sf.getCurrentSession().persist(st);
        }
        public void update(Student st){
            sf.getCurrentSession().saveOrUpdate(st);
        }
        public void delete(Student st){
            sf.getCurrentSession().delete(st);
        }
}
