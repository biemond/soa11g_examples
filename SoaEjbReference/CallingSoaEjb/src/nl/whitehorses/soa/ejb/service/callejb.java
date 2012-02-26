package nl.whitehorses.soa.ejb.service;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import nl.whitehorses.soa.model.hr.entities.Employees;
import nl.whitehorses.soa.model.hr.services.HrModelSessionEJB;

import oracle.integration.platform.blocks.sdox.ejb.api.SOAServiceFactory;
import oracle.integration.platform.blocks.sdox.ejb.api.SOAServiceInvokerBean;


public class callejb {
    public callejb() {
        super();
    }

    public static void main(String[] args) {
        try {


            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
            props.put(Context.PROVIDER_URL, "t3://soaps5:8001");
            InitialContext ctx = new InitialContext(props);
            
            HrModelSessionEJB hrEmployeeEJB = (HrModelSessionEJB)ctx.lookup("SOAHrModelSessionEJB");
            Employees emp = hrEmployeeEJB.getEmployeesFindOne(199L);
            System.out.println(emp.getLastName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
