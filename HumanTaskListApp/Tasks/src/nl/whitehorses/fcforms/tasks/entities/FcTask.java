package nl.whitehorses.fcforms.tasks.entities;

import java.io.Serializable;

import java.util.Calendar;
import java.util.List;


public class FcTask implements Serializable {
    public FcTask() {
        super();
    }

    /**
     *
     */
    private List<String> assignedTo;

    private String assignedToStr;

    /**
     *
     */
    private String acquiredBy;

    /**
     *
     */
    private List<String> assignedGroups;

    /**
     *
     */
    private Calendar expirationDate;


    /**
     *
     */
    private int priority;

    /**
     *
     */
    private String taskId;

    /**
     *
     */
    private int taskNumber;

    /**
     * BPEL process name
     */
    private String processName;

    /**
     * BPEL process category (if relevant)
     */
    private String processCategory;

    /**
     * BPEL process instance id
     */
    private String instanceId;

    /**
     * BPEL process versie
     */
    private String processVersion;

    /**
     * Task description code.
     */
    private String taskDescriptionCode;


    private String title;

    private Calendar created;

    private String state;

    private String outcome;


    private String url;

    private String text1;
    private String text2;
    private String text3;

    private String payloadAsString;
        

    public void setAssignedTo(List<String> assignedTo) {
        this.assignedTo = assignedTo;
    }

    public List<String> getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedGroups(List<String> assignedGroups) {
        this.assignedGroups = assignedGroups;
    }

    public List<String> getAssignedGroups() {
        return assignedGroups;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }


    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setAcquiredBy(String acquiredBy) {
        this.acquiredBy = acquiredBy;
    }

    public String getAcquiredBy() {
        return acquiredBy;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessName() {
        return processName;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setProcessVersion(String processVersion) {
        this.processVersion = processVersion;
    }

    public String getProcessVersion() {
        return processVersion;
    }


    public void setProcessCategory(String processCategory) {
        this.processCategory = processCategory;
    }

    public String getProcessCategory() {
        return processCategory;
    }


    public void setTaskDescriptionCode(String taskDescriptionCode) {
        this.taskDescriptionCode = taskDescriptionCode;
    }

    public String getTaskDescriptionCode() {
        return taskDescriptionCode;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setAssignedToStr(String assignedToStr) {
        this.assignedToStr = assignedToStr;
    }

    public String getAssignedToStr() {
        return assignedToStr;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText1() {
        return text1;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText2() {
        return text2;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText3() {
        return text3;
    }


    public void setPayloadAsString(String payloadAsString) {
        this.payloadAsString = payloadAsString;
    }

    public String getPayloadAsString() {
        return payloadAsString;
    }
}
