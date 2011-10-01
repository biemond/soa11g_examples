package nl.whitehorses.soa.client;

import oracle.fabric.management.deployedcomposites.CompositeManager;

public class ActivateComposite {

    public static void main(String[] args) {
      try {
           CompositeManager.initConnection("soaps3.alfa.local", "8001", "weblogic", "weblogic1");

           CompositeManager.assignDefaultComposite(CompositeManager.getCompositeLifeCycleMBean(), "default/Helloworld!1.0");

           CompositeManager.stopComposite(CompositeManager.getCompositeLifeCycleMBean(), "default/Helloworld!1.0");

           CompositeManager.startComposite(CompositeManager.getCompositeLifeCycleMBean(), "default/Helloworld!1.0");

           CompositeManager.activateComposite(CompositeManager.getCompositeLifeCycleMBean(), "default/Helloworld!1.0");

           CompositeManager.retireComposite(CompositeManager.getCompositeLifeCycleMBean(), "default/Helloworld!1.0");

           System.out.println(CompositeManager.listDeployedComposites(CompositeManager.getCompositeLifeCycleMBean()));

           CompositeManager.closeConnection(); 

      } catch (Exception  e) {
          e.printStackTrace();
      } 
    }
}
