package nl.whitehorses.fcforms.tasks.test;

import java.util.List;

import nl.whitehorses.fcforms.tasks.services.HumanTaskClient;

import oracle.tip.pc.services.identity.BPMGroup;
import oracle.tip.pc.services.identity.BPMUser;

public class QueryBPELGroups {
    public QueryBPELGroups() {
        HumanTaskClient client = new HumanTaskClient();

        System.out.println("groups");
        List<BPMGroup> groups = client.getAllBPELGroups() ;    

        for (BPMGroup group : groups) {
          System.out.println("group: "+group.getName());  
          List<BPMUser> users = client.getAllBPELUsers(group.getName());
          for (BPMUser user : users) {
              System.out.println("user: "+user.getName());  
          }    
        }

        System.out.println("All users");
        List<BPMUser> users = client.getAllBPELUsers();
        for (BPMUser user : users) {
            System.out.println("user: "+user.getName());  
        }    
        
        
    }

    public static void main(String[] args) {
        QueryBPELGroups queryBPELGroups = new QueryBPELGroups();
    }
}
