package nl.whitehorses.fcforms.tasks.test;

import java.util.Calendar;
import java.util.List;

import nl.whitehorses.fcforms.tasks.entities.FcTask;
import nl.whitehorses.fcforms.tasks.services.HumanTaskClient;

import oracle.bpel.services.workflow.WorkflowException;
import oracle.bpel.services.workflow.task.model.Task;

import org.w3c.dom.Element;

public class Query {
    public Query() {
        super();
    }

    public static void main(String[] args) {
        Query query = new Query();
        try {
            query.testQuery();
        } catch (WorkflowException e) {
           e.printStackTrace(); 
        }
    }

    public void testQuery() throws WorkflowException {
        HumanTaskClient client = new HumanTaskClient();

        List<FcTask> tasks = client.getHumanTasks("weblogic",100 , "CRE_DESC", "200011" );         

        for (int i = 0; i < tasks.size(); i++) {
                   FcTask task = tasks.get(i);
                   
                   System.out.println(" task id " + task.getTaskId() +
                                      " acquired " + task.getAcquiredBy()+
                                      " task " + task.getTaskNumber() + 
                                      " title " + task.getTitle() + 
                                      " created " + task.getCreated().getTime().toString() + 
                                      " assignee "+task.getAssignedToStr() +
                                      " state "+task.getState() +
                                      " outcome " + task.getOutcome() +
                                      " text3 " + task.getText3() +
                                      " url " +task.getUrl());
               }
    }

}
