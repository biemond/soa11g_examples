package nl.whitehorses.fcforms.tasks.test;

import nl.whitehorses.fcforms.tasks.services.HumanTaskClient;

public class Assign {
    public Assign() {
        super();
        HumanTaskClient client = new HumanTaskClient();
        client.assignTask("b59738d2-1b54-4a70-92ed-040d044b19da", "weblogic","weblogic", false);


    }
    public static void main(String[] args) {
        Assign assign = new Assign();
    }

}
