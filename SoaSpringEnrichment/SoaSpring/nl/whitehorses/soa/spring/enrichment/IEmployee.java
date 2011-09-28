package nl.whitehorses.soa.spring.enrichment;

import nl.whitehorses.soa.entities.Employee;
public interface IEmployee {

  public Employee enrichEmployee(Integer employeeId, 
                                 String  componentName, 
                                 String  instanceId);

}
