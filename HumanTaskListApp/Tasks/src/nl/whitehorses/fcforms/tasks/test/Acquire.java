package nl.whitehorses.fcforms.tasks.test;

import nl.whitehorses.fcforms.tasks.services.HumanTaskClient;

public class Acquire {
    public Acquire() {
        super();
        HumanTaskClient client = new HumanTaskClient();
        client.acquireTask("b59738d2-1b54-4a70-92ed-040d044b19da", "weblogic", true);

    }

    public static void main(String[] args) {
        Acquire acquire = new Acquire();
    }
}
