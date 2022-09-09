/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gokisoft.receiver;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author DiepTV
 */
@JMSDestinationDefinition(name = "myQueue", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "myQueue")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ReceiverMessageBean implements MessageListener {
    
    public ReceiverMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                String msg = textMessage.getText();
                System.out.println("Hello > " + msg);
            } catch (JMSException ex) {
                Logger.getLogger(ReceiverMessageBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
