
package cs544.sph1.bank.jms;

import java.io.Serializable;


public class TextMessage implements Serializable{
    private String textMessage="";
    public TextMessage(String s){
        textMessage=s;
    }

    public String getTextMessage() {
        return textMessage;
    }
    
}
