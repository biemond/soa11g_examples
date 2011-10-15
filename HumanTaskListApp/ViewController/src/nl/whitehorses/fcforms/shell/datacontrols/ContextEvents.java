package nl.whitehorses.fcforms.shell.datacontrols;

import java.util.HashMap;
import java.util.Map;

import nl.whitehorses.fcforms.shell.backing.Launcher;
import nl.whitehorses.fcforms.tasks.entities.FcTask;

import oracle.adf.view.rich.context.AdfFacesContext;

public class ContextEvents {
    public ContextEvents() {
    }

    public Map<String, Object> fireTaskEvent(String taskId,FcTask task) {  
         System.out.println("fire taskevent ");  
         Map<String, Object> eventData = new HashMap<String, Object>();  
         eventData.put("taskId"  , taskId);  
         eventData.put("task", task);  
         return eventData;  
     }  

    public void captureTaskEvent(Object parameter) {  
          System.out.println("capture task event");  
          Map<String, Object> eventData = (Map<String, Object>)parameter;  
          String taskId = (String)eventData.get("taskId");  
          FcTask task = (FcTask)eventData.get("task");  
    
          AdfFacesContext adfFacesCtx = AdfFacesContext.getCurrentInstance();
          // get the PageFlowScope Params
          Map<String, Object> scopePageFlowScopeVar= adfFacesCtx.getPageFlowScope();
          Launcher launcher = (Launcher)scopePageFlowScopeVar.get("launcher");  
          launcher.multipleTaskActivity(taskId, task);
    }  

}
