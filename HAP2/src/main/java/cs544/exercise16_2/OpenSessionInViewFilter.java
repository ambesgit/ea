package cs544.exercise16_2;

import cs544.exercise16_2.util.HibernateUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {
        private SessionFactory sf;
        public void init(FilterConfig arg) throws ServletException{
            sf=HibernateUtil.getSessionFactory();
             //initializing the database but not the right place to do it here
                Transaction tx=null;
                tx=sf.getCurrentSession().beginTransaction();
                Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);
                sf.getCurrentSession().saveOrUpdate(student);
                tx.commit();
        }

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO implement actual session in view filter code
		
		Transaction tx=null;
		// pass the request along the filter chain
                try{
		System.out.println("receiving request");
                tx=sf.getCurrentSession().beginTransaction();               
		chain.doFilter(request, response);
                tx.commit();
		System.out.println("sending response");
                }
                catch(RuntimeException ex){
                    try{
                        ex.printStackTrace();
                        tx.rollback();
                    }
                    catch(RuntimeException rbtx){
                        System.out.print("can not rollback transaction"+rbtx);
                        rbtx.printStackTrace();
                    }
                }
	}

	public void destroy() {
	}

}
