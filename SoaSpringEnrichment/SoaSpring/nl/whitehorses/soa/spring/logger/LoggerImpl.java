package nl.whitehorses.soa.spring.logger;

public class LoggerImpl implements ILogger {
    public LoggerImpl() {
    }

    public void log(String componentName, 
                    String instanceId, 
                    String message) {
      StringBuffer logBuffer = new StringBuffer ();
      logBuffer.append("[").append(componentName).append("] [Instance: ").
          append(instanceId).append("] ").append(message);
      System.out.println(logBuffer.toString());
    }
}
