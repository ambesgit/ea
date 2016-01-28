
package cs544.jms1;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


public class JMSCalculatorSender {
    private JmsTemplate jmsTemplate;
    public void send(final Calculator calculatore){
        jmsTemplate.send(new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(calculatore);
            }
        });
    
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    
}
