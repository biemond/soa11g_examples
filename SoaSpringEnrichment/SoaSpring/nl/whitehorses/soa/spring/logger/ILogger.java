package nl.whitehorses.soa.spring.logger;

public interface ILogger {

  public void log (String componentName, 
                   String instanceId, 
                   String message);
}
