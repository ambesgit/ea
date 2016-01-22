package cs544.sph2;

import java.io.IOException;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
@Transactional
public class StudentsCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
                        
                ServletContext context=getServletContext();
                WebApplicationContext applicationContext=WebApplicationContextUtils.getWebApplicationContext(context);
                StudentService studentService=applicationContext.getBean("studentService",StudentService.class);
		String studentIdStr = request.getParameter("studentid");
		
		long studentid = -1;
		Student student = null;
		//from string to digit using regular epressions
		if (studentIdStr != null && studentIdStr.matches("\\d+")) {
			studentid = Long.parseLong(studentIdStr);			
			student = studentService.getStudent(studentid);
		}
		
		request.setAttribute("student", student);
		request.getRequestDispatcher("student.jsp").forward(request, response);		

	}

}
