
package cs544.imp1;

import java.util.Date;
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
                    //test objects will be created here
                    Customer cu1=new Customer("ambes","tetemke");
                    Customer cu2=new Customer("frank","jhon");
                    
                    Order or1=new Order(new Date());
                    Order or2=new Order(new Date());
                    
                    cu1.addOrder(or1);
                    cu2.addOrder(or2);
                    
                    OrderLine ol1=new OrderLine(10);
                    OrderLine ol2=new OrderLine(20);
                    
                    or1.addOrderline(ol1);
                    or2.addOrderline(ol2);
                    
                    Product p1=new Product("laptop","it is very fast with lager memory");
                    Product p2= new Product("car","make newbrand , model mymodel color black");
                    Product cd=new CD("artistABC","CD","it is very fast with lager memory");
                    Product dvd=new DVD("genreABC","Genre","it is very good ...");
                    Product book=new Book("Hibernate","Book","very nice book to read");
                    ol1.setProduct(p1);
                    ol2.setProduct(p2);
                    ol1.setProduct(book);
                    ol2.setProduct(dvd);
                    session.save(cd);
                    session.save(cu1);
                    session.save(cu2);
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
                //query will be made from here 
                List<Customer> customers=session.createQuery("from Customer").list();
                System.out.println("###########"+customers.size());
                for(Customer c:customers){
                    System.out.println("customer_name="+c.getFirstName()+" "+c.getLastName());
                    if(!c.getOrders().isEmpty()){
                        for(Order or:c.getOrders()){
                        System.out.println(" orderDate="+or.getDate()+", id="+or.getOrderId());
                        }
                        for(int i=0;i<c.getOrders().size();i++){
                            System.out.println(" OrderLine="+ (c.getOrders().get(i).getOrderLines().get(i).getQuantity()));
                            System.out.println(" Product="+ (c.getOrders().get(i).getOrderLines().get(i).getProduct().getDescription()));
                        }
                    }
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
