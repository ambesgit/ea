
package cs544.sdi1;

import cs544.sdi1.Greeting;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloApp {
    public static void main(String[] arg){
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("springconfig.xml");
        Greeting greetingService=context.getBean("greetingService",Greeting.class);
        greetingService.sayHello();
    }
    
}
