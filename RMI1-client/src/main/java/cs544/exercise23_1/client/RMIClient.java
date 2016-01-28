package cs544.exercise23_1.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cs544.exercise23_1.server.IGreeting;
import cs544.exercise23_1.server.Person;
import cs544.rmi.server.Calculator;
import cs544.rmi.server.ICalculator;
import org.springframework.util.StopWatch;

public class RMIClient {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfigclient.xml");
//		IGreeting remoteServer = context
//				.getBean("helloserver", IGreeting.class);
//		Person person = new Person("John", "Doe");
//		String result = remoteServer.getMessage(person);
                ICalculator remoteServer=context.getBean("helloserver",ICalculator.class);
                Calculator cal=new Calculator(10,"+");
                StopWatch stw=new StopWatch();
                stw.start();
                String result=remoteServer.getCalculator(cal);
                stw.stop();
                System.out.println("tottal time ="+stw.getTotalTimeSeconds());
		System.out.println("Receiving result: " + result);
	}

}
