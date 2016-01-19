package cs544.exercise16_2;

import cs544.exercise16_2.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {
    //private SessionFactory sf=HibernateUtil.getSessionFactory();
	private StudentDAO studentdao;

	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
            //Transaction tx=sf.getCurrentSession().beginTransaction();
                Student student=studentdao.get(studentid);
                /*
                Hibernate.initialize(student.getCourselist());
                */
               // tx.commit();
                return student;
	}
}
