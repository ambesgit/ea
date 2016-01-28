
package cs544.jms1.cal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReceiveObject {
    
    public static void main(String[] args){
        ApplicationContext context=new ClassPathXmlApplicationContext("springconfigreceiver.xml");
        System.out.println("receiver is listening...");
    }
    
}
