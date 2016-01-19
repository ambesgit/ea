package cs544.exercise16_2;

import cs544.exercise16_2.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {
        private static SessionFactory sf=HibernateUtil.getSessionFactory();
	private static Collection<Student> studentlist = new ArrayList<Student>();
     /*
	static {            
           
		Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);
		studentlist.add(student); //this was used with the array so no important now
                Transaction tx=sf.getCurrentSession().beginTransaction();
                sf.getCurrentSession().saveOrUpdate(student);
                tx.commit();

	}	
        */
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
