
package cs544.hpa1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.util.Date;
import java.util.List;

public class AppBook {
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    //----------------******MAIN METHOD*********-------------
    public static void main(String[] args){
        Session session=null;
        Transaction tx=null;
        
        //add books to the database
        try{
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            Book b1=new Book("coreJava", "1234wasert_j", "author1", 23.09, new Date());
            Book b2=new Book("coreHibernate", "1234wasert_s", "author2", 33.09, new Date());
            Book b3=new Book("coreSpring", "1234wasert_h", "author3", 43.09, new Date());
            session.save(b1);
            session.save(b2);
            session.save(b3);
            tx.commit();
        }
        catch(HibernateException e){
              if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        }
        finally{
             if (session != null) {
                session.close();
            }
        }
        
        
        //retrieve all books  from database
        
        try{
            
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            List<Book> books=session.createQuery("from Book").list();
            for(Book book:books){
            System.out.println(book);
            }
            tx.commit();
        }
        catch(HibernateException e){
            if(tx!=null){
            System.out.println("transaction rollback"+ e.getMessage());
            tx.rollback();
            }
        }
        finally{
            if(session!=null){
                session.close();
            }
        }
        
        //retrieve one book from the database
        
        try{
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            System.out.println(session.get(Book.class, 1));
            Book b=(Book)session.get(Book.class, 1);
            b.setTitle("UpdatedVersion");
            b.setPrice(56.89);
            session.update(b);
            session.delete((Book)session.load(Book.class, 2));
            tx.commit();
            
        
        }
        catch(HibernateException e){
            if(tx!=null){
                System.out.println("transaction rollback"+e.getMessage());
                tx.rollback();
            }
        }
        finally{
        if(session!=null){
            session.close();
        }
        }
        
        //After update and delete one record from the database retrieve all
        
        try{
            
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            List<Book> bks=session.createQuery("from Book").list();
            for(Book b:bks){
                System.out.println(b);
            }
            tx.commit();
            
        }
        catch(HibernateException e){
            System.out.println("transaction rollback"+e.getMessage());
            tx.rollback();
        }
        finally{
            if(session!=null){
                session.close();
            }
        }
    }
    
}
