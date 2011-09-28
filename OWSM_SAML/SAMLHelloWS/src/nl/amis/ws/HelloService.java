package nl.amis.ws;

import java.security.Principal;

import java.util.Iterator;
import java.util.Set;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.security.auth.Subject;

import oracle.security.xmlsec.saml.Attribute;
import oracle.security.xmlsec.saml.AttributeStatement;
import oracle.security.xmlsec.wss.saml.SAMLAssertionToken;

import weblogic.wsee.jws.jaxws.owsm.SecurityPolicy;
import weblogic.security.Security;
import weblogic.security.principal.WLSUserImpl;

@WebService
@SecurityPolicy(uri = "oracle/wss11_saml_token_with_message_protection_service_policy")
public class HelloService {
    public HelloService() {
    }

    @WebMethod
    @WebResult(name = "message")
    public String sayHello(@WebParam(name = "name") String name, 
                           @WebParam(name = "message") String message ) {
        
      Subject subject = Security.getCurrentSubject();

      // public
      Set<Object> allPublicPrincipals = subject.getPublicCredentials();
      for (Object principal : allPublicPrincipals) {
        if ( principal instanceof WLSUserImpl ) {
           Principal principal2 = (Principal)principal; 
           System.out.println("public found user: "+principal2.getName());
        }
      }

      // private and virtual
      Set<Object> allPrivatePrincipals = subject.getPrivateCredentials();
      for (Object principal : allPrivatePrincipals) {
         if ( principal instanceof WLSUserImpl ) {
            Principal principal2 = (Principal)principal; 
            System.out.println("private found user: "+principal2.getName());
         }
         // virtual user
         if ( principal instanceof SAMLAssertionToken ) {
            SAMLAssertionToken principal2 = (SAMLAssertionToken)principal; 
            System.out.println("virtual found saml issuer: "+principal2.getIssuer());
            Iterator<AttributeStatement> it =  principal2.getAttributeStatements().iterator();
            while ( it.hasNext() ){
                AttributeStatement attr = it.next();  
                Iterator<Attribute> it2 = attr.getSAMLAttributes().iterator() ;
                while ( it2.hasNext() ){
                  Attribute attr2 = it2.next();  
                  System.out.println("SAML attribute: "+attr2.getAttributeName() );  
                  Iterator<Object> it3 = attr2.getAttributeValues().iterator() ;
                  while ( it3.hasNext() ){
                    Object attr3 = it3.next();  
                    System.out.println("value: "+attr3 );                    
                  }    
                }    
              }
         }  
      }
       return "Hello "+name+", I got your message: "+message;   
    }
}
