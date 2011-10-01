package nl.whitehorses.soa.client;

import java.io.StringWriter;
import java.io.StringReader;

import java.util.Hashtable;
import java.util.Map;
import java.util.HashMap;

import javax.naming.Context;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import oracle.soa.api.PayloadFactory;
import oracle.soa.api.XMLMessageFactory;
import oracle.soa.api.invocation.DirectConnection;
import oracle.soa.api.message.Message;
import oracle.soa.api.message.Payload;

import oracle.soa.management.CompositeDN;
import oracle.soa.management.facade.Locator;
import oracle.soa.management.facade.LocatorFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.InputSource;


public class StartRMIProcess {

    public StartRMIProcess() {
        super();

        Hashtable jndiProps = new Hashtable();
        jndiProps.put(Context.PROVIDER_URL, "t3://soaps3.alfa.local:8001/soa-infra");
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
        jndiProps.put(Context.SECURITY_PRINCIPAL, "weblogic");
        jndiProps.put(Context.SECURITY_CREDENTIALS, "weblogic1");
        jndiProps.put("dedicated.connection", "true");

        Locator locator = null;
        try {
            // connect to the soa server
            locator = LocatorFactory.createLocator(jndiProps);

            // find composite  default domain,  Helloworld Composite, version 1.0 
            CompositeDN compositedn = new CompositeDN("default", "Helloworld", "1.0");

            // call the direct binding of the Helloworld composite
            DirectConnection conn = locator.createDirectConnection(compositedn,"RMIService");
            

            String inputPayload = 
            "<client:process xmlns:client=\"http://xmlns.oracle.com/HelloWorld/Helloworld/BPELProcess1\">\n" + 
            "   <client:input>hello</client:input>\n" + 
            "</client:process>\n" ;
            
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = docBuilderFactory.newDocumentBuilder();
            Document doc =  builder.parse(new InputSource(new StringReader(inputPayload)));
            Element  root = doc.getDocumentElement();

            //<wsdl:message name="BPELProcess1RequestMessage">
            //        <wsdl:part name="payload" element="client:process"/>
            //</wsdl:message>

            Map<String, Element> partData = new HashMap<String,Element>(); 
            // have to use payload see BPELProcess1RequestMessage
            partData.put("payload", root);

            Payload<Element> payload = PayloadFactory.createXMLPayload(partData);

            //Messages are created using the MessageFactory 
            Message<Element> request = XMLMessageFactory.getInstance().createMessage();
            request.setPayload(payload);

            //<wsdl:portType name="BPELProcess1">
            //        <wsdl:operation name="process">
            //                <wsdl:input  message="client:BPELProcess1RequestMessage" />
            //                <wsdl:output message="client:BPELProcess1ResponseMessage"/>
            //        </wsdl:operation>
            //</wsdl:portType>
            // this is a request-reply service so we need to use conn.request else use conn.post
            // need to provide operation name so we need to use process
            Message<Element> response = conn.request("process", request);

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);

            //<wsdl:message name="BPELProcess1ResponseMessage">
            //        <wsdl:part name="payload" element="client:processResponse"/>
            //</wsdl:message>
            // need to use payload again
            DOMSource source =  new DOMSource((Node)response.getPayload().getData().get("payload"));

            transformer.transform(source, result);
            System.out.println("Result\n"+sw.toString());


        
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        StartRMIProcess startRMIProcess = new StartRMIProcess();
    }
}
