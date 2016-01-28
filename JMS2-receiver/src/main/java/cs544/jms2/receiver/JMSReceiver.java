
package cs544.jms2.receiver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JMSReceiver {
    public static void main(String[] args){
        ApplicationContext context= new ClassPathXmlApplicationContext("springconfigreceiver.xml");
        System.out.println("receiver is listening.....");
    }
    
}
