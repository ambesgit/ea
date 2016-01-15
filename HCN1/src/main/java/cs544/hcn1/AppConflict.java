
package cs544.hcn1;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppConflict {
     private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure("conflict.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;
        try{
            
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            Car car=(Car)session.get(Car.class, 1L);
            System.out.println("###########Before update by this Appconflict price=:"+car.getPrice());
            car.setPrice(car.getPrice()+50);                      
            tx.commit();
            System.out.println("##########after commit the update by this Appconflict price=:"+car.getPrice());
            
        }
        catch(HibernateException e){
            if(tx!=null){
                System.out.println("roll transaction "+e.getMessage());
                tx.rollback();
            }
        }
        finally{
        if(session!=null)session.close();
        }
        
        
    }
    
}
