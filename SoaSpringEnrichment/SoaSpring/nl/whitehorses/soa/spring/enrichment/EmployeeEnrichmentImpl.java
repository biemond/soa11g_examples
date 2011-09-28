package nl.whitehorses.soa.spring.enrichment;

import nl.whitehorses.soa.entities.Department;
import nl.whitehorses.soa.entities.Employee;
import nl.whitehorses.soa.model.hr.entities.Employees;
import nl.whitehorses.soa.spring.logger.ILogger;
import nl.whitehorses.soa.model.hr.services.HrModelSessionEJB;
import nl.whitehorses.soa.model.hr.services.HrSessionBeanService;

public class EmployeeEnrichmentImpl implements IEmployee {
    public EmployeeEnrichmentImpl() {
    }

    private ILogger loggerReference;
    private HrModelSessionEJB hrModelReference;
    private HrSessionBeanService hrWSModelReference;
    private IEmployeeMediator mediatorReference;

    public Employee enrichEmployee(Integer employeeId, 
                                   String  componentName, 
                                   String  instanceId) {

        // log the request.
        loggerReference.log(componentName, instanceId, "Enrich employee: "+employeeId);

        // get the employee from the SOA Suite Reference
        Employees emp = hrModelReference.getEmployeesFindOne(employeeId);
        
        // get the department from the WebLogic SCA Reference
        nl.whitehorses.soa.model.hr.services.Departments dept = hrWSModelReference.getDepartmentsFindOne(emp.getDepartmentId());
        
        Department department  = new Department();
        department.setDepartmentId(dept.getDepartmentId().intValue());
        department.setName(dept.getDepartmentName());
        
        Employee employee = new Employee();
        employee.setEmployeeId(emp.getEmployeeId().intValue());
        employee.setFirstName(emp.getFirstName());
        employee.setLastName(emp.getLastName());
        employee.setDepartment(department);
        employee.setState("logged");
        
        mediatorReference.processEmployee(employee);

        return employee;
    }

   
    public void setLoggerReference(ILogger loggerReference) {
        this.loggerReference = loggerReference;
    }

    public ILogger getLoggerReference() {
        return loggerReference;
    }

    public void setHrModelReference(HrModelSessionEJB hrModelReference) {
        this.hrModelReference = hrModelReference;
    }

    public HrModelSessionEJB getHrModelReference() {
        return hrModelReference;
    }


    public void setHrWSModelReference(HrSessionBeanService hrWSModelReference) {
        this.hrWSModelReference = hrWSModelReference;
    }

    public HrSessionBeanService getHrWSModelReference() {
        return hrWSModelReference;
    }

    public void setMediatorReference(IEmployeeMediator mediatorReference) {
        this.mediatorReference = mediatorReference;
    }

    public IEmployeeMediator getMediatorReference() {
        return mediatorReference;
    }
}
