package nl.whitehorses.adf.edn;

import java.util.Properties;

import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.transaction.UserTransaction;

import javax.xml.namespace.QName;

import oracle.fabric.blocks.event.BusinessEventConnection;
import oracle.fabric.blocks.event.BusinessEventConnectionFactory;

import oracle.integration.platform.blocks.event.BusinessEventBuilder;
import oracle.integration.platform.blocks.event.jms.JmsRemoteBusinessEventConnectionFactory;

import oracle.soa.common.util.XMLUtil;

import org.w3c.dom.Element;


public class PublishJMSEvent {

    public static void main(String[] args) {

        // My SOA WebLogic variables
        Properties props = new Properties();
        props.put(Context.PROVIDER_URL, "t3://soaps3.alfa.local:8001");
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                  "weblogic.jndi.WLInitialContextFactory");
        props.put(Context.SECURITY_PRINCIPAL, "weblogic");
        props.put(Context.SECURITY_CREDENTIALS, "weblogic1");

        // the business Event
        String EmployeeEvent = "EmployeeEvent";
        String NameSpace =
            "http://schemas.oracle.com/events/edl/EmployeeEventEDL";

        String EmployeeEventBody =
            "<Employee xmlns=\"http://nl.whitehorses.employee.event\">" +
            "<Id>110</Id>" + 
            "</Employee>";

        Element eventBody = null;
        try {
            eventBody =
                    XMLUtil.parseDocumentFromXMLString(
                        EmployeeEventBody.toString()).getDocumentElement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // EDN JMS environment
        String connFactName = "jms/fabric/EDNConnectionFactory";
        String xaConnFactName = "jms/fabric/xaEDNConnectionFactory";
        String queueName = "jms/fabric/EDNQueue";

        try {
            InitialContext context = new InitialContext(props);

            // do a jndi lookup on the Server
            UserTransaction userTransaction =
                (UserTransaction)context.lookup("javax.transaction.UserTransaction");
            QueueConnectionFactory queueConnectionFactory =
                ((QueueConnectionFactory)context.lookup(connFactName));
            QueueConnectionFactory xaQueueConnectionFactory =
                ((QueueConnectionFactory)context.lookup(xaConnFactName));
            Queue jmsQueue = ((Queue)context.lookup(queueName));


            BusinessEventConnectionFactory factory =
                new JmsRemoteBusinessEventConnectionFactory(queueConnectionFactory,
                                                            xaQueueConnectionFactory,
                                                            jmsQueue,
                                                            userTransaction);

            BusinessEventConnection conn =
                factory.createBusinessEventConnection();
            
            // Create an event
            BusinessEventBuilder builder = BusinessEventBuilder.newInstance();
            builder.setEventName(new QName(NameSpace, EmployeeEvent));
            builder.setBody(eventBody);

            // publish
            conn.publishEvent(builder.createEvent(), 4);
            conn.close();

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
}


