
package cs544.exercise16_2.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//Singletone session factory generator class and only one sessionFactory is needed
//the static block makes sure only one sessionFactory is exist for the whole application
//so need to make the default constructor private 
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static{
        try{
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
        applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        catch(Throwable ex){
            System.err.println("Initial Session factory creation failed. "+ ex);
           throw new ExceptionInInitializerError(ex);
        }
    
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    
    }
}
