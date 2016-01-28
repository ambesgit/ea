
package cs544.rmi2.client;

import cs544.sph1.bank.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMIClient {
    public static void main(String[] args){
    ApplicationContext context=new ClassPathXmlApplicationContext("springconfigclient.xml");
    IAccountService accountService=context.getBean("helloserver",IAccountService.class);
    System.out.println("**********Remote call to display all Accounts******************");
    System.out.println(accountService.getAccount(4253892).getCustomer().getName());
    }
   
}
