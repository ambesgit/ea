
package cs544.amp2App;


import cs544.amp2.Department;
import cs544.amp2.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    private static final SessionFactory sessionFactory;
    static {
        Configuration configure=new Configuration();
        configure.configure();
        ServiceRegistry registry=new  StandardServiceRegistryBuilder().applySettings(
                        configure.getProperties()).build();
        sessionFactory=configure.buildSessionFactory(registry);
    
    }
    
    public static void main(String[] args){
        Session session=null;
        Transaction tx=null;
        try{
            employeeDepartment(session,tx);
        }
        catch(HibernateException e){
            handleCatch(tx,e);
        }
        finally{
        handleSession(session);
        }
    }
   
  private static void handleCatch(Transaction tx,HibernateException e){
      if(tx!=null){          
          System.out.println("rollback transaction" + e.getMessage());
          tx.rollback();
      }
 
  } 
    private static void handleSession(Session s){
        if(s!=null)s.close();
   } 
    private static void employeeDepartment(Session s, Transaction t){
            s=sessionFactory.openSession();
            t=s.beginTransaction();
            Employee emp0=new Employee("ambes");
            Employee emp1=new Employee("tetemke");
            Department dep0=new Department("JavaDep");
            Department dep1=new Department("FrontEnd");
            dep0.addEmployee(emp1);
            dep1.addEmployee(emp0);
            s.save(dep0);
            s.save(dep1);            
            t.commit();
    }
}
