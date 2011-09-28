package osb.cookbook.owsm.client;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import oracle.webservices.ClientConstants;

import osb.cookbook.owsm.types.CustomerTyp;
import weblogic.wsee.jws.jaxws.owsm.SecurityPoliciesFeature;

public class CustomerManagementSOAPQSPortClient
{
  @WebServiceRef
  private static CustomerManagementSOAPQSService customerManagementSOAPQSService;

  public static void main(String [] args) throws MalformedURLException {
    customerManagementSOAPQSService = 
        new CustomerManagementSOAPQSService(new URL("http://soaps3.alfa.local:8011/01_Securing-an-OSB-service/proxy/Customer?WSDL"),
                                            new QName("http://osb-cookbook/CustomerManagement", 
                                                      "CustomerManagementSOAPQSService"));
//    // user authentication
//    SecurityPoliciesFeature securityFeatures =
//            new SecurityPoliciesFeature(new String[] { "oracle/wss_username_token_client_policy" });
//    // message protection.
//    SecurityPoliciesFeature securityFeatures =
//            new SecurityPoliciesFeature(new String[] { "oracle/wss11_message_protection_client_policy" });
//    SecurityPoliciesFeature securityFeatures =
//            new SecurityPoliciesFeature(new String[] { "oracle/wss10_message_protection_client_policy" });

//    // message protection with username token.
//    SecurityPoliciesFeature securityFeatures =
//            new SecurityPoliciesFeature(new String[] { "oracle/wss11_username_token_with_message_protection_client_policy" });
    SecurityPoliciesFeature securityFeatures =
            new SecurityPoliciesFeature(new String[] { "oracle/wss10_username_token_with_message_protection_client_policy" });

    
    // message protection with username token.
//    SecurityPoliciesFeature securityFeatures =
//            new SecurityPoliciesFeature(new String[] { "oracle/wss11_x509_token_with_message_protection_client_policy" });

    CustomerManagement customerManagement = 
            customerManagementSOAPQSService.getCustomerManagementSOAPQSPort(securityFeatures);

    Map<String, Object> reqContext = ((BindingProvider)  customerManagement).getRequestContext();  
//    // Add the user
    reqContext.put(BindingProvider.USERNAME_PROPERTY, "osbbook" );
    reqContext.put(BindingProvider.PASSWORD_PROPERTY, "weblogic1" );

    // message protection 11g
//    reqContext.put(ClientConstants.WSSEC_KEYSTORE_TYPE, "JKS");
//    reqContext.put(ClientConstants.WSSEC_KEYSTORE_LOCATION, "c:/oracle/client_1.jks");
//    reqContext.put(ClientConstants.WSSEC_KEYSTORE_PASSWORD, "welcome");
//
//    reqContext.put(ClientConstants.WSSEC_ENC_KEY_ALIAS, "serverkey");
//    reqContext.put(ClientConstants.WSSEC_ENC_KEY_PASSWORD, "welcome");
//    reqContext.put(ClientConstants.WSSEC_RECIPIENT_KEY_ALIAS, "serverkey");

      // certs
//    reqContext.put(ClientConstants.WSSEC_KEYSTORE_TYPE, "JKS");
//    reqContext.put(ClientConstants.WSSEC_KEYSTORE_LOCATION, "c:/oracle/client_2.jks");
//    reqContext.put(ClientConstants.WSSEC_KEYSTORE_PASSWORD, "welcome");
//
//    reqContext.put(ClientConstants.WSSEC_ENC_KEY_ALIAS, "serverkey");
//    reqContext.put(ClientConstants.WSSEC_ENC_KEY_PASSWORD, "welcome");
//    reqContext.put(ClientConstants.WSSEC_RECIPIENT_KEY_ALIAS, "serverkey");
//
//    reqContext.put(ClientConstants.WSSEC_SIG_KEY_ALIAS, "clientkey");  
//    reqContext.put(ClientConstants.WSSEC_SIG_KEY_PASSWORD, "welcome");

    // 10g
    reqContext.put(ClientConstants.WSSEC_KEYSTORE_TYPE, "JKS");
    reqContext.put(ClientConstants.WSSEC_KEYSTORE_LOCATION, "c:/oracle/client_2.jks");
    reqContext.put(ClientConstants.WSSEC_KEYSTORE_PASSWORD, "welcome");

    reqContext.put(ClientConstants.WSSEC_ENC_KEY_ALIAS, "clientkey");
    reqContext.put(ClientConstants.WSSEC_ENC_KEY_PASSWORD, "welcome");
    reqContext.put(ClientConstants.WSSEC_RECIPIENT_KEY_ALIAS, "serverkey");

    reqContext.put(ClientConstants.WSSEC_SIG_KEY_ALIAS, "clientkey");  
    reqContext.put(ClientConstants.WSSEC_SIG_KEY_PASSWORD, "welcome");


        
    // call the operation.
    CustomerTyp customer = customerManagement.findCustomer(10L);
    System.out.println( "Firstname: "+customer.getFirstName()
                       +" Lastname: "+customer.getLastName());
  }
}
