package osb.cookbook.owsm;

import java.io.FileNotFoundException;

import java.rmi.RemoteException;

import java.util.Properties;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyEngine;

import org.apache.rampart.RampartMessageData;
import org.apache.rampart.policy.model.CryptoConfig;
import org.apache.rampart.policy.model.RampartConfig;

import osb_cookbook.customermanagement.CustomerManagementSOAPQSServiceStub;
import osb_cookbook.customermanagement.FindCustomer;
import osb_cookbook.customermanagement.FindCustomerResponse;

public class TestClient {

    public static void main(String[] args) throws AxisFault, RemoteException,
                                                  Exception {

        ConfigurationContext ctx = ConfigurationContextFactory
         .createConfigurationContextFromFileSystem("C:/java/axis2-1.6.0/repository",
                                                   "C:/java/axis2-1.6.0/conf/axis2.xml");

        CustomerManagementSOAPQSServiceStub stub =
            new CustomerManagementSOAPQSServiceStub(ctx,
                                                    "http://SOAPS3.alfa.local:8011/01_Securing-an-OSB-service/proxy/Customer");

        ServiceClient client = stub._getServiceClient();
        Options clientOptions = client.getOptions();

        Policy policyRequest  = loadPolicy("./policy_request.xml");
        Policy policyResponse = loadPolicy("./policy_response.xml");

        clientOptions.setProperty(RampartMessageData.KEY_RAMPART_OUT_POLICY, policyRequest);
        clientOptions.setProperty(RampartMessageData.KEY_RAMPART_IN_POLICY, policyResponse);

        client.setOptions(clientOptions);
        client.engageModule("addressing");
        client.engageModule("rampart");
  
        stub._setServiceClient(client);
      
        FindCustomer params = new FindCustomer();
        params.setID(100L);
        FindCustomerResponse response = stub.findCustomer(params);
        System.out.println(response.getCustomer().getLastName());
    }

     private static Policy loadPolicy(String filePath)
          throws XMLStreamException, FileNotFoundException {
      StAXOMBuilder builder = new StAXOMBuilder(filePath);
      return PolicyEngine.getPolicy(builder.getDocumentElement());
    }
}
