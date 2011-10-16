package nl.whitehorses.fcforms.shell.backing;

import java.util.Map;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import nl.whitehorses.fcforms.tasks.entities.FcTask;

import oracle.adf.controller.ControllerContext;
import oracle.adf.controller.internal.binding.DCTaskFlowBinding;
import oracle.adf.model.BindingContext;
import oracle.adf.model.bean.DCDataRow;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adfinternal.controller.state.ChildViewPortContextImpl;
import oracle.adfinternal.controller.state.RootViewPortContextImpl;
import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;

public class TaskBean {


    public TaskBean() {
    }

    private String  username = "weblogic";
    private Long    maxRows  = 50L;
    private String  orderBy  = "PRIO";
    private String  searchString  = null;


    public void acquire(ActionEvent actionEvent) {
        // Add event code here...
        // get the binding container
        executeTask("acquireTask");
    }

    public void reject(ActionEvent actionEvent) {
        // Add event code here...
        executeTask("rejectTask");
    }

    public void approve(ActionEvent actionEvent) {
        // Add event code here...
        executeTask("completeTask");
    }


    public void executeTask(String action) {
        BindingContainer bindings =
            BindingContext.getCurrent().getCurrentBindingsEntry();


        // get an Action or MethodAction
        OperationBinding method = bindings.getOperationBinding(action);
        method.execute();

        OperationBinding method2 = bindings.getOperationBinding("getHumanTasks");
        method2.execute();


    }

    public void showTask(ActionEvent actionEvent) {
        // Add event code here...
        AdfFacesContext adfFacesCtx = AdfFacesContext.getCurrentInstance();
        // get the PageFlowScope Params
        Map<String, Object> scopePageFlowScopeVar= adfFacesCtx.getPageFlowScope();
        String taskId = (String)scopePageFlowScopeVar.get("taskId");
        System.out.println("task: "+taskId);

        FacesCtrlHierNodeBinding rowData = (FacesCtrlHierNodeBinding)scopePageFlowScopeVar.get("task");  
        Row row = rowData.getRow();  
        FcTask task = (FcTask)((DCDataRow)row).getDataProvider() ;  
        
        // get the binding container  
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding method = bindings.getOperationBinding("fireTaskEvent");  
        Map paramsMap = method.getParamsMap();  
        paramsMap.put("taskId",taskId)  ;        
        paramsMap.put("task"  ,task)  ;        
        method.execute();  
        
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void humanTaskChanged(ValueChangeEvent valueChangeEvent) {

        // Add event code here...
        BindingContainer bindings =
            BindingContext.getCurrent().getCurrentBindingsEntry();

        OperationBinding method2 = bindings.getOperationBinding("getHumanTasks");
        method2.execute();

    }


    public void setMaxRows(Long maxRows) {
        this.maxRows = maxRows;
    }

    public Long getMaxRows() {
        return maxRows;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchString() {
        return searchString;
    }
}
