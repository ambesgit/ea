
package cs544.jms1.cal;

import cs544.jms1.Calculator;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class DoTheMath implements MessageListener{

    public synchronized void  onMessage(Message msg) {
        ObjectMessage objMessage=(ObjectMessage)msg;
        try{
            Calculator cal=(Calculator)objMessage.getObject();
            System.out.println(cal.calculate());
        }
        catch(Exception e){
            System.out.println("Check the object you send......");
            e.printStackTrace();
        }
    }
    
    
}
