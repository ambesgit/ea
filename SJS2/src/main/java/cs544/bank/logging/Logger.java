package cs544.bank.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class Logger implements ILogger{
        
	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);		
	}
        @After("execution(* cs544.bank.dao.*.*(..))")
        public void loggingAllMethodsInBankDAO(JoinPoint joinPoint){
            log("Logging from package bank.dao:"+" method="+joinPoint.getSignature().getName());
        }
        @Around("execution(* cs544.bank.service.*.*(..))")
        public Object getExecutionTime(ProceedingJoinPoint call) throws Throwable{
            StopWatch sw=new StopWatch("");
            sw.start(call.toShortString());
            Object reTurn=call.proceed();
            sw.stop();
            long tTime=sw.getLastTaskTimeMillis();
            log("From bank service package: "+" ,Method="+call.getSignature().getName()+" ,totalTimeOf execution="+tTime);
            return reTurn;  
        }
        @After("execution(* cs544.bank.jms.*.*(..))&& args(text)")
        public void getEveryJMS(JoinPoint joinPoint,String text){
            System.out.println("XXXXXXXXXXXX JMSMESSAGE ABOVE THIS LINEXXXXXXXXXXXXXXXX");
                log(text);
        }

}
