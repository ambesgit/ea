
package cs544.jms2.receiver;

import cs544.sph1.bank.jms.TextMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;



public class JMSMessage implements MessageListener{

    @Override
    public void onMessage(Message msg) {
       ObjectMessage objMessage=(ObjectMessage)msg;
       try{
           TextMessage text=(TextMessage)objMessage.getObject();
           System.out.println(text.getTextMessage());
       }
       catch(Exception e){
            //e.printStackTrace();
       }
    }
    
}
