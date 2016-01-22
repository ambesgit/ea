package cs544.sph2;

import org.springframework.transaction.annotation.Transactional;


@Transactional
public class StudentService {
    //private SessionFactory sf=HibernateUtil.getSessionFactory();
	private StudentDAO studentdao;

	public StudentService(StudentDAO st) {
		studentdao = st;
	}

    public void setStudentdao(StudentDAO studentdao) {
        this.studentdao = studentdao;
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
