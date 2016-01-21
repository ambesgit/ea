
package cs544.aop1;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class LoggerAdvicer {
    @After("execution(* cs544.aop1.EmailSender.sendEmail(..)) && args(address, message)")
    public void logMessage(JoinPoint joinPoint,String address, String message){
        EmailSender emailSender=(EmailSender)joinPoint.getTarget();
            System.out.println(new Date()+" method="+joinPoint.getSignature().getName()
                    +" addres="+address+ " \nmessage="+message
                    +" \nOutgoing mail server="+emailSender.outgoingMailServer);
      
        
    }
    @Around("execution(* cs544.aop1.CustomerDAO.save(..))")
    public Object invoke(ProceedingJoinPoint call) throws Throwable{
        StopWatch sw =new StopWatch("");
        sw.start(call.toShortString());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime=sw.getLastTaskTimeMillis();
        System.out.println("Time to execute save="+totaltime);
        return  retVal;
    }
    
}
