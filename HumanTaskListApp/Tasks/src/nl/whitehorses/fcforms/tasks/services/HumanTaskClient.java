package nl.whitehorses.fcforms.tasks.services;

import java.util.ArrayList;
import java.util.List;

import nl.whitehorses.fcforms.tasks.entities.FcTask;
import nl.whitehorses.fcforms.tasks.utility.BPELWorkflowServices;
import nl.whitehorses.fcforms.tasks.utility.TaskConvertor;

import oracle.bpel.services.workflow.task.model.Task;
import oracle.bpel.services.workflow.verification.IWorkflowContext;

import oracle.tip.pc.services.identity.BPMGroup;
import oracle.tip.pc.services.identity.BPMUser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class HumanTaskClient {

    /**
     * Logger.
     */
    private static final Log logger = LogFactory.getLog(HumanTaskClient.class);

    /**
     * Maximum aantal taken dat in ��n keer verwerkt mag worden door BPEL PM.
     */
    private static final int MAXIMUM_NUMBER_OF_TASKS = 200;

    /**
     *
     */
    private BPELWorkflowServices workflowServices;

    private TaskConvertor taskConvertor;

    /**
     * Constructor.
     */
    public HumanTaskClient() {

        logger.debug("[START] HumanTaskServicesBean()");

        workflowServices = new BPELWorkflowServices();
        taskConvertor = new TaskConvertor();
        logger.debug("[EINDE] HumanTaskServicesBean()");
    }



    public List<FcTask> getHumanTasks(String user, 
                                      int noOfRecords, 
                                      String orderBy,
                                      String searchString) {

        long startTime = System.currentTimeMillis();
        noOfRecords =
                (noOfRecords == 0 ? MAXIMUM_NUMBER_OF_TASKS : noOfRecords);

        if (  orderBy == null ) {
          orderBy = "PRIO";
        }
 

        logger.info("[START] getHumanTasks()");

        logger.info("\t" + "User: " + user);
        logger.info("\t" + "Number of records: " + noOfRecords);
        System.out.println("Number of records: " + noOfRecords);

        validateUser(user, false);

        List<FcTask> resultSet = null;

        try {

            IWorkflowContext context = workflowServices.authenticate(user);

            List<Task> tasks = workflowServices.queryTasks(context, 
                                                           noOfRecords,
                                                           orderBy,
                                                           searchString);
            resultSet = new ArrayList<FcTask>(tasks.size());
                        
                        
           for (Task task : tasks) {
             resultSet.add(taskConvertor.convertTask(task));
           }
            

        } catch (Throwable t) {
            System.out.println(t.getMessage());
            logger.error(t.getMessage(), t);
            throw new RuntimeException(t.getMessage());
        }

        logger.debug("\t" + "Aantal tasks: " + resultSet.size());
        System.out.println("\t" + "Aantal tasks: " + resultSet.size());
        logger.debug("[EINDE] getHumanTasks()");

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("[EINDE] getHumanTasks() in " + elapsedTime);

        return resultSet;
    }


    public void assignTask(String taskId, String currentUser,
                           String futureUser, boolean isGroup) {
        long startTime = System.currentTimeMillis();

        logger.debug("[START] assignTask()");

        logger.debug("\t" + "Taak id: " + taskId);
        logger.debug("\t" + "Is group: " + isGroup);

        validateUser(currentUser, false);
        validateUser(futureUser, isGroup);

        try {

            IWorkflowContext context =
                workflowServices.authenticate(currentUser);

            List<String> taskIds = new ArrayList<String>();

            taskIds.add(taskId);

            workflowServices.validateTaskStates(context, taskIds);
            workflowServices.validateTasksAreAcquired(context, taskIds);

            context = workflowServices.authenticate(null);

            // Assign aan group via reassign
            if (isGroup) {

                workflowServices.assignTask(context, taskId, futureUser,
                                            isGroup);
            }
            // Assign aan persoon via release en acquire
            else {

                releaseTask(taskId, currentUser);

                acquireTask(taskId, futureUser, true);
            }
        } catch (Throwable t) {

            logger.error(t.getMessage(), t);
            throw new RuntimeException(t.getMessage());
        }

        logger.debug("[EINDE] assignTask()");

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("[EINDE] assignTask() in " + elapsedTime);

    }



    public void acquireTask(String taskId, String user,
                            boolean isAllowedToBeAcquiredByUser) {
        long startTime = System.currentTimeMillis();

        logger.debug("[START] acquireTask()");

        logger.debug("\t" + "Task id: " + taskId);
        logger.debug("\t" + "User: " + user);
        logger.debug("\t" + "is allowed to be acquired by user: " +
                     isAllowedToBeAcquiredByUser);

        validateUser(user, false);

        try {

            IWorkflowContext context = workflowServices.authenticate(user);

            List<String> taskIds = new ArrayList<String>();

            taskIds.add(taskId);

            workflowServices.validateTaskStates(context, taskIds);

            workflowServices.acquireTask(context, taskId,
                                         isAllowedToBeAcquiredByUser);
        } catch (Throwable t) {

            logger.error(t.getMessage(), t);
            throw new RuntimeException(t.getMessage());
        }

        logger.debug("[EINDE] acquireTask()");
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("[EINDE] acquireTask() in " + elapsedTime);
    }




    public void releaseTask(String taskId, String user) {
        long startTime = System.currentTimeMillis();


        logger.debug("[START] releaseTask()");

        logger.debug("\t" + "Task id: " + taskId);

        validateUser(user, false);

        try {

            IWorkflowContext context = workflowServices.authenticate(user);

            List<String> taskIds = new ArrayList<String>();

            taskIds.add(taskId);

            workflowServices.validateTaskStates(context, taskIds);
            workflowServices.validateTasksAreAcquired(context, taskIds);

            workflowServices.releaseTask(context, taskId);
        } catch (Throwable t) {

            logger.error(t.getMessage(), t);
            throw new RuntimeException(t.getMessage());
        }

        logger.debug("[EINDE] releaseTask()");
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("[EINDE] releaseTask() in " + elapsedTime);


    }



    public void completeTask(String taskId, String outcome, String user, String comment) {
        long startTime = System.currentTimeMillis();


        logger.warn("[START] completeTask()");

        logger.warn("\t" + "Task id: " + taskId);
        logger.warn("\t" + "Task outcome: " + outcome);

        validateUser(user, false);

        try {

            // Validate task and outcome
            if (taskId == null || outcome == null) {

                throw new IllegalArgumentException("Ongeldige waarden voor taskId: " +
                                                   taskId + " en outcome: " +
                                                   outcome);
            }

            IWorkflowContext context = workflowServices.authenticate(user);

            // Check whether tasks are assigned
            List<String> taskIds = new ArrayList<String>();
            taskIds.add(taskId);

            workflowServices.validateTaskStates(context, taskIds);
            workflowServices.validateTasksAreAcquired(context, taskIds);

            // Complete tasks
            workflowServices.completeTask(context, taskId,
                                          outcome.toUpperCase(), comment);
        } catch (Throwable t) {

            logger.error(t.getMessage(), t);
            throw new RuntimeException(t.getMessage());
        }

        logger.warn("[EINDE] completeTask()");
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("[EINDE] completeTask() in " + elapsedTime);
    }




    private void validateUser(String name, boolean isGroup) {

        logger.debug("[START] validateUser()");

        logger.debug("\t" + "Meegegeven gebruiker/groep: " + name);


        if (name == null || name.trim().length() == 0) {

            throw new IllegalArgumentException("Gebruiker of groep is null");
        }


        logger.debug("[EINDE] validateUser()");
    }


    public void setErrorCodeTask(String errorCode, String taskId,
                                 String user) {

        logger.debug("[START] setErrorCodeTask()");

        logger.debug("\t" + "Task id: " + taskId);
        logger.debug("\t" + "Error code: " + errorCode);
        logger.debug("\t" + "User: " + user);

        setTextAttributeOnTask("ERROR_CODE", errorCode, taskId, user);

        logger.debug("[EINDE] setErrorCodeTask()");
    }


    public void setTextAttributeOnTask(String attribute, String value,
                                       String taskId, String user) {

        logger.debug("[START] setTextAttributeOnTask()");

        logger.debug("\t" + "Task id: " + taskId);
        logger.debug("\t" + "Attribute: " + attribute);
        logger.debug("\t" + "Value: " + value);
        logger.debug("\t" + "User: " + user);

        validateUser(user, false);

        try {

            IWorkflowContext context = workflowServices.authenticate(user);

            List<String> taskIds = new ArrayList<String>();

            taskIds.add(taskId);

            workflowServices.validateTaskStates(context, taskIds);
            workflowServices.validateTasksAreAcquired(context, taskIds);

            Task task = workflowServices.getTaskDetail(context, taskId);


            workflowServices.updateTask(context, task);
        } catch (Throwable t) {

            logger.error("Fout in setErrorCodeTask(): " + t.getMessage(), t);
            throw new RuntimeException("Fout in setErrorCodeTask()");
        }

        logger.debug("[EINDE] setTextAttributeOnTask()");
    }


    public List<BPMUser> getAllBPELUsers(String groupName) {

        logger.debug("[START] getAllHipposBPELUsers()");

        logger.debug("\t" + "Group name: " + groupName);

        try {

            // Retrieve BPM users
            List<BPMUser> bpmUsers =
                workflowServices.getAllBPELUsers(groupName);

            if (bpmUsers == null) {

                logger.error("No Hippos users found");

                return null;
            }

            logger.debug("[EINDE] getAllHipposBPELUsers()");

            return bpmUsers;
        } catch (Throwable t) {

            logger.error("Fout in getAllHipposUsers(): " + t.getMessage());
            throw new RuntimeException("Fout in getAllHipposUsers()");
        }
    }

    public List<BPMUser> getAllBPELUsers() {

        logger.debug("[START] getAllHipposBPELUsers()");


        try {

            // Retrieve BPM users
            List<BPMUser> bpmUsers = workflowServices.getAllBPELUsers();

            if (bpmUsers == null) {

                logger.error("No Hippos users found");

                return null;
            }

            logger.debug("[EINDE] getAllHipposBPELUsers()");

            return bpmUsers;
        } catch (Throwable t) {

            logger.error("Fout in getAllHipposUsers(): " + t.getMessage());
            throw new RuntimeException("Fout in getAllHipposUsers()");
        }
    }


    public List<BPMGroup> getAllBPELGroups() {

        logger.debug("[START] getAllBPELGroups()");

        try {

            // Retrieve BPM groups
            List<BPMGroup> bpmGroups = workflowServices.getAllBPELGroups();

            if (bpmGroups == null) {

                logger.error("No BPEL groups found");

                return null;
            }

            logger.debug("[EINDE] getAllBPELGroups()");

            return bpmGroups;
        } catch (Throwable t) {

            logger.error("Fout in getAllBPELGroups(): " + t.getMessage());
            throw new RuntimeException("Fout in getAllsBPELGroups()");
        }
    }


}
