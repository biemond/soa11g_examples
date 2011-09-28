package nl.whitehorses.soa.model.hr.services;

import java.util.List;

import javax.ejb.Remote;

import nl.whitehorses.soa.model.hr.entities.Departments;
import nl.whitehorses.soa.model.hr.entities.Employees;

@Remote
public interface HrModelSessionEJB {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    List<Employees> getEmployeesFindAll();

    Employees getEmployeesFindOne(long empId);

    List<Departments> getDepartmentsFindAll();

    Departments getDepartmentsFindOne(long deptId);

    Employees createEmployee( Employees employee );

}
