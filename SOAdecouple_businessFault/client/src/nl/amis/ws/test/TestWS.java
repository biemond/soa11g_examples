package nl.amis.ws.test;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.xml.rpc.soap.SOAPFaultException;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceRef;

import nl.amis.ws.client.BusinessFaultMessage;
import nl.amis.ws.client.FrontMediator_ep;
import nl.amis.ws.client.Front_ptt;
import nl.amis.ws.types.Departments;
import nl.amis.ws.types.InputDepartmentType;
import nl.amis.ws.types.ObjectFactory;

import oracle.adf.share.logging.ADFLogger;
import oracle.jbo.JboException;
import oracle.jbo.common.ResourceBundleDef;

public class TestWS {
  public TestWS() {
  }
    
  private static ADFLogger logger = ADFLogger.createADFLogger(TestWS.class);

  @WebServiceRef
  private static FrontMediator_ep frontMediator_ep;

  private static ResourceBundle messages = 
       ResourceBundle.getBundle("nl.amis.ws.bundle.ClientBundle",Locale.getDefault());  

  public static void main(String [] args)  {


    frontMediator_ep = new FrontMediator_ep();
    Front_ptt front_ptt = frontMediator_ep.getFront_pt();
    ObjectFactory obj = new ObjectFactory();
    InputDepartmentType input = obj.createInputDepartmentType();
    Integer department = 101;
    input.setDepartmentId(department);
    try {
        Departments dep = front_ptt.validateDepartment(input);
        logger.log(ADFLogger.NOTIFICATION,"Department =" + dep.getDepartmentId());
    } catch (BusinessFaultMessage e) {
        logger.warning("got a business fault: " + 
                       e.getFaultInfo().getFaultCode() + 
                       " message: "+
                       e.getFaultInfo().getFaultDesciption());
        throw new JboException( messages.getString( e.getFaultInfo().getFaultCode()),
                                e.getFaultInfo().getFaultCode(),
                                new String[] { department.toString() });
    } catch (SOAPFaultException e) {
        logger.severe("got soap fault: "+ e.getMessage());
        throw new JboException( messages.getString("MyFault-999"),
                                "MyFault-999",
                                null);
    } catch (WebServiceException e) {
        logger.severe("got web service fault: "+ e.getMessage());
        throw new JboException( messages.getString("MyFault-999"),
                                "MyFault-999",
                                null );
    }
  }
}
