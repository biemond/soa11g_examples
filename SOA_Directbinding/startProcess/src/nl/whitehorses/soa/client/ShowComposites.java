package nl.whitehorses.soa.client;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;

import oracle.soa.management.facade.ComponentInstance;
import oracle.soa.management.facade.Composite;
import oracle.soa.management.facade.CompositeInstance;
import oracle.soa.management.facade.Locator;
import oracle.soa.management.facade.LocatorFactory;
import oracle.soa.management.util.ComponentInstanceFilter;
import oracle.soa.management.util.CompositeInstanceFilter;

public class ShowComposites {

    public ShowComposites() {

        Hashtable jndiProps = new Hashtable();
        jndiProps.put(Context.PROVIDER_URL, "t3://soaps3.alfa.local:8001/soa-infra");
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,
                      "weblogic.jndi.WLInitialContextFactory");
        jndiProps.put(Context.SECURITY_PRINCIPAL, "weblogic");
        jndiProps.put(Context.SECURITY_CREDENTIALS, "weblogic1");
        jndiProps.put("dedicated.connection", "true");


        Locator locator = null;
        try {
            // connect to the soa server
            locator = LocatorFactory.createLocator(jndiProps);

            // find composite
            Composite composite =
                locator.lookupComposite("default/Helloworld!1.0");


            System.out.println("instances");


            CompositeInstanceFilter filter = new CompositeInstanceFilter();
            filter.setMinCreationDate(new java.util.Date((System.currentTimeMillis() -
                                                          200000000)));
            // get composite instances by filter ..
            List<CompositeInstance> obInstances =
                composite.getInstances(filter);
            // for each of the returned composite instances..
            for (CompositeInstance instance : obInstances) {
                System.out.println(" DN: " + instance.getCompositeDN() +
                                   " Instance: " + instance.getId() +
                                   " creation-date: " +
                                   instance.getCreationDate() + " state (" +
                                   instance.getState() + "): " +
                                   getStateAsString(instance.getState()));

                // setup a component filter
                ComponentInstanceFilter cInstanceFilter =
                    new ComponentInstanceFilter();
                // get child component instances ..
                List<ComponentInstance> childComponentInstances =
                    instance.getChildComponentInstances(cInstanceFilter);

                // for each child component instance (e.g. a bpel process)
                for (ComponentInstance cInstance : childComponentInstances) {
                    

                    System.out.println("  -> componentinstance: " +
                                       cInstance.getComponentName() +
                                       " type: " +
                                       cInstance.getServiceEngine().getEngineType() +
                                       " state: " +
                                       getStateAsString(cInstance.getState())+ cInstance.getState() );
                    System.out.println("State: " +
                                       cInstance.getNormalizedStateAsString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ShowComposites comp = new ShowComposites();
    }


    private String getStateAsString(int state) {
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
        else if (state == CompositeInstance.STATE_TERMINATED_BY_USER)
            return ("terminated");
        else
            return ("unknown");
    }


}
