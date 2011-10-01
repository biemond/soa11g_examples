package nl.whitehorses.soa.client;

import java.util.Hashtable;
import java.util.UUID;
import java.util.List;

import javax.naming.Context;

import oracle.soa.management.facade.Locator;
import oracle.soa.management.facade.LocatorFactory;
import oracle.soa.management.facade.Composite;
import oracle.soa.management.facade.Service;
import oracle.soa.management.facade.CompositeInstance;
import oracle.soa.management.facade.ComponentInstance;


import oracle.fabric.common.NormalizedMessage;
import oracle.fabric.common.NormalizedMessageImpl;

import oracle.soa.management.util.CompositeInstanceFilter;
import oracle.soa.management.util.ComponentInstanceFilter;


import java.util.Map;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.Element;
import java.io.*;



public class StartProcess {
    public StartProcess() {
        super();

        Hashtable jndiProps = new Hashtable();
        jndiProps.put(Context.PROVIDER_URL, "t3://soaps3.alfa.local:8001/soa-infra");
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
        jndiProps.put(Context.SECURITY_PRINCIPAL, "weblogic");
        jndiProps.put(Context.SECURITY_CREDENTIALS, "weblogic1");
        jndiProps.put("dedicated.connection", "true");

        String inputPayload = 
        "<process xmlns=\"http://xmlns.oracle.com/HelloWorld/Helloworld/BPELProcess1\">" + 
        "   <input>hello</input>" + 
        "</process>" ;


        Locator locator = null;
        try {
            // connect to the soa server
            locator = LocatorFactory.createLocator(jndiProps);
            String compositeDN = "default/Helloworld!1.0";

            // find composite
            Composite composite = locator.lookupComposite("default/Helloworld!1.0");
            
            System.out.println("Got Composite : "+ composite.toString());

            // find exposed service of the composite
            Service service = composite.getService("ADFBindingService");
            System.out.println("Got serviceName : "+ service.toString()); 

            // make the input request and add this to a operation of the service
            NormalizedMessage input = new NormalizedMessageImpl();
            String uuid = "uuid:" + UUID.randomUUID();
            input.addProperty(NormalizedMessage.PROPERTY_CONVERSATION_ID,uuid);

            // payload is the partname of the process operation
            input.getPayload().put("payload",inputPayload);




            // process is the operation of the employee service
            NormalizedMessage res = null;
            try {
               res = service.request("process", input);
            } catch(Exception e) {
               e.printStackTrace();
            }


            Map payload = res.getPayload();
            Element element = (Element)payload.get("payload");

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);


            DOMSource source =  new DOMSource(element);

            transformer.transform(source, result);
            System.out.println("Result\n"+sw.toString());

            System.out.println("instances");
            
            
            CompositeInstanceFilter filter = new CompositeInstanceFilter();
            filter.setMinCreationDate(new java.util.Date((System.currentTimeMillis() -  2000000)));
            // get composite instances by filter ..
            List<CompositeInstance> obInstances = composite.getInstances(filter);
            // for each of the returned composite instances..
            for (CompositeInstance instance : obInstances) {
                System.out.println(" DN: " + instance.getCompositeDN() +
                                   " Instance: " + instance.getId() + 
                                   " creation-date: " + instance.getCreationDate() + 
                                   " state (" + instance.getState() + "): " + getStateAsString(instance.getState())
                                   );
                                  
                // setup a component filter
                ComponentInstanceFilter cInstanceFilter = new ComponentInstanceFilter();
                // get child component instances ..
                List<ComponentInstance> childComponentInstances = instance.getChildComponentInstances(cInstanceFilter);

                // for each child component instance (e.g. a bpel process)
                for (ComponentInstance cInstance : childComponentInstances) {
                    System.out.println("  -> componentinstance: " + cInstance.getComponentName() + 
                                       " type: " + cInstance.getServiceEngine().getEngineType() + 
                                       " state: " +getStateAsString(cInstance.getState())
                                       );
                    System.out.println("State: "+cInstance.getNormalizedStateAsString()  );                 
                }
            }
  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private String getStateAsString(int state)
    {
        // note that this is dependent on wheter the composite state is captured or not
        if (state == CompositeInstance.STATE_COMPLETED_SUCCESSFULLY)
            return ("success");
        else if (state == CompositeInstance.STATE_FAULTED)
            return ("faulted");
        else if (state == CompositeInstance.STATE_RECOVERY_REQUIRED)
            return ("recovery required");
        else if (state == CompositeInstance.STATE_RUNNING)
            return ("running");
        else if (state == CompositeInstance.STATE_STALE)
            return ("stale");
        else
            return ("unknown");
    }


    public static void main(String[] args) {
        StartProcess startUnitProcess = new StartProcess();
    }
}
