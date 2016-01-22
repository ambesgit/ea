package cs544.sph1.app;

import cs544.sph1.bank.domain.Account;
import cs544.sph1.bank.domain.AccountEntry;
import cs544.sph1.bank.domain.Customer;
import cs544.sph1.bank.service.AccountServiceSpring;
import cs544.sph1.bank.service.IAccountService;
import java.util.Collection;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * Hello world!
 *
 */

public class App         
{
    
    public static void main( String[] args )
      {
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("springconfig.xml");
        IAccountService accountServiceSpring=context.getBean("accountService",IAccountService.class);
        
        //to create some entry and store in the database this is not recommended any ways
   
    accountServiceSpring.createAccount(1263862, "Frank Brown");
            accountServiceSpring.createAccount(4253892, "John Doe");
            // use account 1;
            accountServiceSpring.deposit(1263862, 240);
           accountServiceSpring.deposit(1263862, 529);
            accountServiceSpring.withdrawEuros(1263862, 230);
            // use account 2;
            accountServiceSpring.deposit(4253892, 12450);
            accountServiceSpring.depositEuros(4253892, 200);
            accountServiceSpring.transferFunds(4253892, 1263862, 100,
                    "payment of invoice 10232");
            // show balances

            Collection<Account> accountlist = accountServiceSpring.getAllAccounts();

            Customer customer = null;
            for (Account account : accountlist) {
                customer = account.getCustomer();
                System.out.println("Statement for Account: "
                        + account.getAccountnumber());
                System.out.println("Account Holder: " + customer.getName());
                System.out.println("-Date-------------------------"
                        + "-Description------------------"
                        + "-Amount-------------");
                for (AccountEntry entry : account.getEntryList()) {
                    System.out.printf("%30s%30s%20.2f\n", entry.getDate()
                            .toString(), entry.getDescription(), entry
                            .getAmount());
                }
                System.out.println("----------------------------------------"
                        + "----------------------------------------");
                System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
                        account.getBalance());
            }
    
    
    }
        
      
    
}
