package nl.whitehorses.fcforms.tasks.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import oracle.bpel.services.common.exception.ServicesException;

import oracle.security.idm.User;
import oracle.bpel.services.workflow.client.IWorkflowServiceClientConstants;
import oracle.bpel.services.workflow.client.WorkflowServiceClientFactory;

import oracle.security.idm.IMException;
import oracle.security.idm.IdentityStore;

import oracle.security.idm.Property;
import oracle.security.idm.PropertySet;
import oracle.security.idm.Role;
import oracle.security.idm.RoleManager;
import oracle.security.idm.RoleProfile;
import oracle.security.idm.UserManager;

import oracle.security.idm.UserProfile;

import oracle.tip.pc.services.identity.AttributeNames;
import oracle.tip.pc.services.identity.BPMIdentityException;
import oracle.tip.pc.services.identity.BPMIdentityNotFoundException;
import oracle.tip.pc.services.identity.BPMIdentityService;
import oracle.tip.pc.services.identity.BPMUnsupportedAttributeException;
import oracle.tip.pc.services.identity.BPMUser;
import oracle.tip.pc.services.identity.config.BPMIdentityConfigService;
import oracle.tip.pc.services.identity.jps.JpsProvider;
import oracle.tip.pc.services.identity.config.ProviderCfg;

public class IdentityClient {

    private static Logger logger2 = Logger.getLogger(IdentityClient.class.getName());

    private String soaserver      = "soaps3.alfa.local";
    private String soaserver_port = "8001";
    private String wsurl          = "http://"+soaserver+":"+soaserver_port;

    private BPMIdentityService       bpmClient;     
    private BPMIdentityConfigService bpmConfig ;
    private String                   identityDomain      = "jazn.com";    
    private IdentityStore            identityStore;
    
    public IdentityClient() throws BPMIdentityException, Exception {
        Map<IWorkflowServiceClientConstants.CONNECTION_PROPERTY,java.lang.String> properties = 
            new HashMap<IWorkflowServiceClientConstants.CONNECTION_PROPERTY,java.lang.String>();

        properties.put(IWorkflowServiceClientConstants.CONNECTION_PROPERTY.SOAP_END_POINT_ROOT
                      , wsurl);

        bpmClient = WorkflowServiceClientFactory.getSOAPIdentityServiceClient(identityDomain
                                                                              , properties
                                                                              , logger2);
        
        bpmConfig = WorkflowServiceClientFactory.getSOAPIdentityConfigServiceClient( properties
                                                                                   , logger2);

        String realmName = bpmConfig.getDefaultRealmName();
        ProviderCfg conf = bpmConfig.getConfiguration(realmName).getProviderCfg("Authorization");
        
        System.out.println("default realm: "+realmName);



    }

    public List<BPMUser> getAllUsers() throws BPMIdentityException,
                                              BPMUnsupportedAttributeException {
        return  bpmClient.searchUsers(AttributeNames.NAME_ATTRNAME, "*"); 
    }


    public void addUser(String name, String email, String manager) throws IMException {
        UserManager usrmgr = identityStore.getUserManager();

        User user = null;
        try {
          user = identityStore.searchUser(name);
        } catch(IMException e) { }
        
        if(user != null) {
           System.out.println("user "+name+" exists"); 
        } else {
            PropertySet pset = new PropertySet();
            pset.put(new Property("DESCRIPTION", name));
            pset.put(new Property("USER_NAME", name));
            pset.put(new Property("USER_ID", name));
            
            char pwd[] = "weblogic".toCharArray();
            
            user = usrmgr.createUser(name, pwd, pset);
            user = identityStore.searchUser(user.getName());
            UserProfile up = user.getUserProfile();
            up.setBusinessEmail(email);
            User userManager = null;
            try {
              userManager = identityStore.searchUser(manager);
            } catch(IMException ie) { }
            if(manager != null) {
              up.setManager(userManager.getUniqueName());
            }
        }
    }

    private void addGroup(String group, List<String> members) throws IMException
    {
        RoleManager rolemgr = identityStore.getRoleManager();
        Role role = null;
        try {
          role = identityStore.searchRole(1, group);
        } catch(IMException e) { }
        if(role == null) {
           role = rolemgr.createRole(group);
        }

        RoleProfile rolePrf = role.getRoleProfile();

        if(members != null && members.size() > 0)  {
          for(int m = 0; m < members.size(); m++) {
            User user = null;
            try {
              user = identityStore.searchUser((String)members.get(m));
            } catch(IMException e) { }
            if(user != null) {
              rolemgr.grantRole(role, user.getPrincipal());
            }
          }
       }
    }


    public void removeUser(String user) throws Exception
    {
        UserManager usrmgr = identityStore.getUserManager();
        if( user != null) { 
          User idtyUser = null;
          try {
           idtyUser = identityStore.searchUser(user);
          } catch(IMException e) {}

          if(idtyUser != null) {
           usrmgr.dropUser(idtyUser);
          }
        }  
    }

    public void removeGroup(String role) throws Exception
    {
        RoleManager rolemgr = identityStore.getRoleManager();
        Role idtyRole = null;
        try {
          idtyRole = identityStore.searchRole(1, role);
        } catch(IMException e) {}

        if(idtyRole != null){
          rolemgr.dropRole(idtyRole);
        }
    }

    public static void main(String[] args) throws BPMIdentityException,
                                                  BPMIdentityNotFoundException,
                                                  ServicesException,
                                                  Exception {
        IdentityClient identityClient = new IdentityClient();

        List<BPMUser> users = identityClient.getAllUsers();
        System.out.println("All users");
        for ( BPMUser user : users ) {
          System.out.println("name: "+user.getName()+"manager: "+user.getManager());  
        }
    }
}
