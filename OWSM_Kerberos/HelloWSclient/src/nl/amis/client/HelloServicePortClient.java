package nl.amis.client;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import oracle.webservices.ClientConstants;
import weblogic.wsee.jws.jaxws.owsm.SecurityPoliciesFeature;

public class HelloServicePortClient
{
  @WebServiceRef
  private static HelloServiceService helloServiceService;

  public static void main(String [] args) throws MalformedURLException {
    URL wsdl = new URL("http://soaps3.alfa.local:6001/Kerberos-KerberosHelloWS-context-root/HelloServicePort?WSDL");
    QName qname =  new QName("http://ws.kerberos.owsm.amis.nl/", 
                             "HelloServiceService");

    helloServiceService = new HelloServiceService(wsdl,qname);
    SecurityPoliciesFeature securityFeatures =
      new SecurityPoliciesFeature(
         new String[] { "oracle/wss11_kerberos_token_with_message_protection_basic128_client_policy" });
   

    HelloService helloService = helloServiceService.getHelloServicePort(securityFeatures);
    Map<String, Object> reqContext = ((BindingProvider)  helloService).getRequestContext();  
    reqContext.put(ClientConstants.WSSEC_KERBEROS_SERVICE_PRINCIPAL, 
                   "HTTP/soaps3.alfa.local@ALFA.LOCAL" );

    System.out.println(helloService.sayHello("Edwin", "Hi"));

  }
}
