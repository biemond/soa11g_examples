package nl.whitehorses.fcforms.tasks.utility;


import java.io.IOException;
import java.io.StringWriter;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

import nl.whitehorses.fcforms.tasks.entities.FcTask;

import oracle.bpel.services.workflow.task.model.IdentityType;
import oracle.bpel.services.workflow.task.model.SystemAttributesType;
import oracle.bpel.services.workflow.task.model.Task;

import oracle.xml.parser.v2.XMLElement;


public class TaskConvertor {
    public TaskConvertor() {
        super();
    }
    private static final SimpleDateFormat format =
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public FcTask convertTask(Task task) {

        FcTask fcTask = new FcTask();
        SystemAttributesType systemAttributes = task.getSystemAttributes();
        fcTask.setTaskId(task.getSystemAttributes().getTaskId());
        fcTask.setAcquiredBy(task.getSystemAttributes().getAcquiredBy());
        fcTask.setAssignedTo( systemAttributes.getAssigneeUsers());
        fcTask.setPriority(task.getPriority());
        fcTask.setAssignedGroups(convertListToArrayList(getAssignedGroups(task)));
        fcTask.setExpirationDate(systemAttributes.getExpirationDate());
        fcTask.setTaskNumber(task.getSystemAttributes().getTaskNumber());
        fcTask.setProcessName(task.getProcessInfo().getProcessName());
        fcTask.setProcessVersion(task.getProcessInfo().getProcessVersion());
        fcTask.setTitle(task.getTitle());

        fcTask.setCreated(systemAttributes.getCreatedDate());
        fcTask.setState(task.getSystemAttributes().getState());
        fcTask.setOutcome( task.getSystemAttributes().getOutcome());

        fcTask.setUrl(task.getSystemMessageAttributes().getUrlAttribute1());
        fcTask.setText1(task.getSystemMessageAttributes().getTextAttribute1());
        fcTask.setText2(task.getSystemMessageAttributes().getTextAttribute2());
        fcTask.setText3(task.getSystemMessageAttributes().getTextAttribute3());

        // payload
        XMLElement payload = (XMLElement)task.getPayloadAsElement();
        StringWriter writer = new StringWriter();
        try {
            payload.print(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        fcTask.setPayloadAsString(writer.toString());
 
        try {
            fcTask.setAssignedToStr(getAssigneeString(task));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fcTask;
    }


    public String getAssigneeString(Task task) throws Exception {
        List assignees = task.getSystemAttributes().getAssigneeUsers();
        StringBuffer buffer = null;
        for (int i = 0; i < assignees.size(); i++) {
            IdentityType type = (IdentityType)assignees.get(i);
            String name = type.getId();
            if (buffer == null) {
                buffer = new StringBuffer();
            } else {
                buffer.append(",");
            }
            buffer.append(name).append("(U)");
        }
        assignees = task.getSystemAttributes().getAssigneeGroups();
        for (int i = 0; i < assignees.size(); i++) {
            IdentityType type = (IdentityType)assignees.get(i);
            String name = type.getId();
            if (buffer == null) {
                buffer = new StringBuffer();
            } else {
                buffer.append(",");
            }
            buffer.append(name).append("(G)");
        }
        if (buffer == null) {
            return "";
        } else {
            return buffer.toString();
        }
    }



    public List<String> getAssignedGroups(Task task) {
        // Return waarde
        List<String> assignedGroups = new ArrayList<String>();
        SystemAttributesType systemAttributes = task.getSystemAttributes();
        List assigneeGroups = systemAttributes.getAssigneeGroups();
        IdentityType currentIdentity = null;
        // Itereer over assigned groups
        for (Object assigneeGroup : assigneeGroups) {
            currentIdentity = (IdentityType)assigneeGroup;
            assignedGroups.add(currentIdentity.getId());
        }

        return assignedGroups;
    }

    private List convertListToArrayList(List sourceList) {
        if (sourceList == null) {
            return null;
        }
        
        if (sourceList.size() == 0) {
            return new ArrayList();
        }
        
        List targetList = new ArrayList(sourceList.size());
        targetList.addAll(sourceList);
        
        return targetList;
    }
  


}
