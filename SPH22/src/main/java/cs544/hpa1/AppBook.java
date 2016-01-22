
package cs544.hpa1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppBook {
    private static final EntityManagerFactory entityManager=Persistence.createEntityManagerFactory("cs544_HPA2"); 
    

    
    //----------------******MAIN METHOD*********-------------
    public static void main(String[] args){
        EntityManager entityMgr=null;
        EntityTransaction tx=null;
        
        //add books to the database
        try{
            entityMgr=entityManager.createEntityManager();
            tx=entityMgr.getTransaction();
            tx.begin();
            Book b1=new Book("coreJava", "1234wasert_j", "author1", 23.09, new Date());
            Book b2=new Book("coreHibernate", "1234wasert_s", "author2", 33.09, new Date());
            Book b3=new Book("coreSpring", "1234wasert_h", "author3", 43.09, new Date());
            entityMgr.persist(b1);
            entityMgr.persist(b2);
            entityMgr.persist(b3);
            tx.commit();
        }
        catch(HibernateException e){
              if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        }
        finally{
             if (entityMgr != null) {
                entityMgr.close();
            }
        }
        
        
        //retrieve all books  from database
        
        try{
            
            entityMgr=entityManager.createEntityManager();
            tx=entityMgr.getTransaction();
            tx.begin();
            List<Book> books=entityMgr.createQuery("from Book").getResultList();
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
            if(entityMgr!=null){
                entityMgr.close();
            }
        }
        
        //retrieve one book from the database
        
        try{
            entityMgr=entityManager.createEntityManager();
            tx=entityMgr.getTransaction();
            tx.begin();
            System.out.println(entityMgr.find(Book.class, 1));
            Book b=(Book)entityMgr.find(Book.class, 1);
            b.setTitle("UpdatedVersion");
            b.setPrice(56.89);
            entityMgr.flush();
            entityMgr.remove((Book)entityMgr.find(Book.class, 2));
            tx.commit();
            
        
        }
        catch(HibernateException e){
            if(tx!=null){
                System.out.println("transaction rollback"+e.getMessage());
                tx.rollback();
            }
        }
        finally{
        if(entityMgr!=null){
            entityMgr.close();
        }
        }
        
        //After update and delete one record from the database retrieve all
        
        try{
            
            entityMgr=entityManager.createEntityManager();
            tx=entityMgr.getTransaction();
            tx.begin();
            List<Book> bks=entityMgr.createQuery("select b from Book b").getResultList();
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
            if(entityMgr!=null){
                entityMgr.close();
            }
        }
    }
    
}
