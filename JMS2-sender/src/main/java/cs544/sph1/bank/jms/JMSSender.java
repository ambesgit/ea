package cs544.sph1.bank.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


public class JMSSender implements IJMSSender{
	private JmsTemplate jmsTemplate;
	public void sendJMSMessage (final String text){
            jmsTemplate.send(new MessageCreator(){
                public Message createMessage(Session sn) throws JMSException {
                    TextMessage textMessage=new TextMessage(text);
                    return sn.createObjectMessage(textMessage);
                }
        });
		
	}

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

}
