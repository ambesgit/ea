package cs544.exercise25_1.client;

import java.util.Collection;

import cs544.exercise25_1.generated.customer.Customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cs544.exercise25_1.service.ICustomerService;

public class CustomerApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		ICustomerService remoteService = context.getBean("customerServiceProxy", ICustomerService.class);
		System.out.println(remoteService.getCustomer("ABC123456").getName());
		// TODO add 3 customers & print customers list
                remoteService.addCustomer(new Customer("s123abc","customer1"));
                remoteService.addCustomer(new Customer("s456edf","customer2"));
                remoteService.addCustomer(new Customer("s789ghi","customer3"));
                printCustomers(remoteService.getCustomers());
//               
		// TODO update 1 customer & print customers list
//		
                remoteService.updateCustomer(new Customer("123abc","updatedcustomer1"));
                printCustomers(remoteService.getCustomers());
//		// TODO delete 1 customer & print customers list
                remoteService.deleteCustomer("123abc");
                printCustomers(remoteService.getCustomers());
	}
	
	public static void printCustomers(Collection<Customer> customers) {
		for (Customer customer : customers) {
			System.out.println(customer.getName() + " " + customer.getCustomerNumber());
		}
		System.out.println();
	}
}
