package nl.whitehorses.soa.model.hr.services;

import java.util.List;

import javax.ejb.Remote;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import javax.jws.WebResult;

import nl.whitehorses.soa.model.hr.entities.Departments;
import nl.whitehorses.soa.model.hr.entities.Employees;

@Remote
public interface HrModelSessionEJB {

    @WebMethod (exclude = true)
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    List<Employees> getEmployeesFindAll();

    @WebResult(name = "EmployeesResult")
    Employees getEmployeesFindOne( @WebParam(name = "empId") long empId);

    List<Departments> getDepartmentsFindAll();

    Departments getDepartmentsFindOne(long deptId);

    Employees createEmployee( Employees employee );

}
