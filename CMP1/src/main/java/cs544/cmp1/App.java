
package cs544.cmp1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        
        //A
        biOneToMany(session,tx);
        
        //B
        uniOneToMany(session,tx);
        
        //C        
       uniOneToManyWithMap(session,tx);
        
     }
     
     
     
     
     //for problem A which is bidirectional onetomany/manytoone
     
     private static void biOneToMany(Session session, Transaction tx){
         
          try{
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            //----------
            Set<Laptop> lps=new HashSet();
            //the collection should be created here and added using the setter
            Employee emp1=new Employee("emp1","empl");
            Laptop lap1= new Laptop("dell","mac");
            lps.add(lap1);
            lap1.setOwner(emp1);
            emp1.setLaptops(lps);
            session.save(emp1);
            tx.commit();
            
        }
        catch(HibernateException e){
            if(tx!=null){
            System.out.println("Transaction rollback, "+e.getMessage());
            tx.rollback();
            }
        }
        finally{
            if(session!=null) session.close();
        }
        
        try{
            
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            List<Employee> employees=session.createQuery("from Employee").list();
            for(Employee em:employees){
                System.out.println("employee_id="+em.getId()+", firstName="+em.getFirstName()+
                        ", lastName="+em.getLastName()+", laptopBrand=");
                if(!em.getLaptops().isEmpty()){
                    for(Laptop p:em.getLaptops()){
                    System.out.println("laptopBrand="+p.getBrand()+", lapTopType="+p.getType());
                    }
                }
            }
            tx.commit();
        }
        catch(HibernateException e){
            if(tx!=null){
                System.out.println("transaction rollback , "+e.getMessage());
                tx.rollback();
            }
        }
        finally{
            if(session!=null) session.close();
        }
        
     
     
     }
     
     //--------------------B------------------------
     
     //for problem B unidirectionalOneToMany using List
      private static void uniOneToMany(Session session, Transaction tx){
         
          try{
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            //----------//
            List<Flight> fts=new ArrayList();
            Passenger ps1=new Passenger("passengerone");
            Flight ft1=new Flight("IA","DC",123,new Date());
            Flight ft2=new Flight("DC","GA",456,new Date());
            Flight ft3=new Flight("GA","FA",786,new Date());
            fts.add(ft1);
            fts.add(ft2);
            fts.add(ft3);
            ps1.setFlight(fts);
            session.save(ps1);
            tx.commit();
            
        }
        catch(HibernateException e){
            if(tx!=null){
            System.out.println("Transaction rollback, "+e.getMessage());
            tx.rollback();
            }
        }
        finally{
            if(session!=null) session.close();
        }
        
        try{
            
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            List<Passenger> passengers=session.createQuery("from Passenger").list();
            for(Passenger em:passengers){
                System.out.println("passengers_id="+em.getId()+", firstName="+em.getName());
                if(!em.getFlight().isEmpty()){
                    for(Flight p:em.getFlight()){
                    System.out.println("from="+p.getFrom()+", to="+p.getTo());
                    }
                }
            }
            tx.commit();
        }
        catch(HibernateException e){
            if(tx!=null){
                System.out.println("transaction rollback , "+e.getMessage());
                tx.rollback();
            }
        }
        finally{
            if(session!=null) session.close();
        }
        
     
     
     }
      
      
      //----------------------C--------------------
      private static void uniOneToManyWithMap(Session session, Transaction tx){
         
          try{
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            //----------//
            Student st1=new Student(1,"std1","lastname1");
            Student st2=new Student(2,"std2","lastname2");
            Map<Integer,Student> stds=new HashMap();
            stds.put(st1.getStudentId(), st1);
            stds.put(st2.getStudentId(),st2);
            School sch=new School("MUM");
            sch.setStudents(stds);
            session.save(sch);
            tx.commit();
            
        }
        catch(HibernateException e){
            if(tx!=null){
            System.out.println("Transaction rollback, "+e.getMessage());
            tx.rollback();
            }
        }
        finally{
            if(session!=null) session.close();
        }
        
        try{
            
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            //
            
            
            //
            tx.commit();
        }
        catch(HibernateException e){
            if(tx!=null){
                System.out.println("transaction rollback , "+e.getMessage());
                tx.rollback();
            }
        }
        finally{
            if(session!=null) session.close();
        }
        
     
     
     }
     
    
}
