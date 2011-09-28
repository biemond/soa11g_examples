package nl.amis.owsm.kerberos.ws;

import java.security.Principal;

import java.util.Set;
import javax.jws.WebService;
import javax.security.auth.Subject;

import weblogic.security.Security;
import weblogic.security.principal.WLSUserImpl;

import weblogic.wsee.jws.jaxws.owsm.SecurityPolicy;

@WebService
@SecurityPolicy(uri = "oracle/wss11_kerberos_token_with_message_protection_basic128_service_policy")
public class HelloService {


    public String sayHello( String name,  String message ) {
      
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

    }
     return "Hello "+name+", I got your message: "+message;   
  }

}
