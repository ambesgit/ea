
package cs544.hcn1;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppCar {
     private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Create new instance of Car and set values in it
            Car car1 = new Car("BMW", "SDA231", 30221.00);
            // save the car
            session.persist(car1);
            // Create new instance of Car and set values in it
            Car car2 = new Car("Mercedes", "HOO100", 4088.00);
            // save the car
            session.persist(car2);

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        //test for concurrency 
        
        try{
            
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            Car car=(Car)session.get(Car.class, 1L);
            System.out.println("#########before any update in the Appcar  price=" +car.getPrice());
            car.setPrice(car.getPrice()-10);
             
            System.out.println("###########Going to sleep");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AppCar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            tx.commit();
            System.out.println("#########after commit of the Appcar price=" +car.getPrice());
            
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
        
        //end's the test for concurrency 

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // retieve all cars
            @SuppressWarnings("unchecked")
            List<Car> carList = session.createQuery("from Car").list();
            for (Car car : carList) {
                System.out.println("brand= " + car.getBrand() + ", year= "
                        + car.getYear() + ", price= " + car.getPrice());
            }
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        // Close the SessionFactory (not mandatory)
        sessionFactory.close();
        System.exit(0);
    }
    
}
