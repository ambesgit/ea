
package cs544.jms1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CalculatoreApp {
    public static void main(String[] args){
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("springconfigsender.xml");
        JMSCalculatorSender jmsCal=context.getBean("jmsCalculatorSender",JMSCalculatorSender.class);
        Calculator calculator=new Calculator(23,45,"+");
        jmsCal.send(calculator);
        System.out.println("send the object to the client ....");
        context.close();
    }
}
