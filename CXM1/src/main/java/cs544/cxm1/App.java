
package cs544.cxm1;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
     private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
     public static void main(String[] args){
        Session session=null;
        Transaction tx=null;
        
      //Test the application
            testSave(session,tx);
            testQuery(session,tx);
        
     }
     
     private static void testSave(Session session, Transaction tx){
         
                try{
                    session=sessionFactory.openSession();
                    tx=session.beginTransaction();
                    //------------SAMPLE----------//
                    Appointment ap=new Appointment("15/05/2008");
                    Payment py=new Payment("12/06/2008",100);
                    Patient pt=new Patient("John Doe","100 Main Street","23114","Boston");
                    Doctor dc=new Doctor("Eye Doctor","Frank","Brown");
                    ap.setPayment(py);
                    ap.setDoctor(dc);
                    ap.setPatient(pt);
                    session.save(ap);
                    tx.commit();
                
                }
                catch(HibernateException e){
                    if(tx!=null){
                    System.out.println("Transaction rollback"+e.getMessage());
                        tx.rollback();
                    }
                }
                finally{
                    if(session!=null) session.close();
                }
     
     }
     private static void testQuery(Session session, Transaction tx){
            try{
            
                session=sessionFactory.openSession();
                tx=session.beginTransaction();
                //-------------Checking the persistency------//
                Appointment ap=(Appointment)session.get(Appointment.class, 1);
                if(ap!=null){
                System.out.println("Id="+ap.getId()+", appdate="+ap.getAppdate()+
                        ", Amount="+ap.getPayment().getAmount()+", Patient="+ap.getPatient().getName()+
                        ", address="+ap.getPatient().getStreet()+",doctor="+
                        ap.getDoctor().getFirstName());
                }
                
                tx.commit();
                
                
            }
            catch(HibernateException e){
                if(tx!=null){
                    System.out.println("Transaction rollback"+e.getMessage());
                        tx.rollback();
                    }
            }
            finally{
            if(session!=null)session.close();
            
            }
     }
    
}
