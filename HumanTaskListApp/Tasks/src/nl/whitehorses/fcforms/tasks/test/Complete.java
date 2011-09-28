package nl.whitehorses.fcforms.tasks.test;

import nl.whitehorses.fcforms.tasks.services.HumanTaskClient;

public class Complete {
    public Complete() {
        super();
        HumanTaskClient client = new HumanTaskClient();
        client.completeTask("b59738d2-1b54-4a70-92ed-040d044b19da","APPROVE", "weblogic", null);


    }
    public static void main(String[] args) {
        Complete complete = new Complete();
    }
}
