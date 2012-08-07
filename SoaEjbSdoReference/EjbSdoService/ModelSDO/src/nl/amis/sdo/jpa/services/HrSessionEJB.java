package nl.amis.sdo.jpa.services;

import java.util.List;

import javax.ejb.Remote;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import javax.jws.WebResult;

import javax.jws.soap.SOAPBinding;

import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import nl.amis.sdo.jpa.entities.Departments;
import nl.amis.sdo.jpa.entities.DepartmentsSDO;
import nl.amis.sdo.jpa.entities.Employees;
import nl.amis.sdo.jpa.entities.EmployeesSDO;

import oracle.webservices.annotations.PortableWebService;
import oracle.webservices.annotations.SDODatabinding;


@Remote
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, style = SOAPBinding.Style.DOCUMENT)
@PortableWebService(targetNamespace="/nl.amis.sdo.jpa.services/",
    name="HrSessionEJBBeanWS", wsdlLocation="nl/amis/sdo/jpa/services/HrSessionEJBBeanWS.wsdl")
@SDODatabinding(schemaLocation="nl/amis/sdo/jpa/services/HrSessionEJBBeanWS.xsd")
public interface HrSessionEJB {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    Departments persistDepartments(Departments departments);

    Departments mergeDepartments(Departments departments);

    void removeDepartments(Departments departments);

    List<Departments> getDepartmentsFindAll();

    List<Departments>  getDepartmentsFindOne( Long deptId);

    Employees persistEmployees(Employees employees);

    Employees mergeEmployees(Employees employees);

    void removeEmployees(Employees employees);

    List<Employees> getEmployeesFindAll();

    List<Employees> getEmployeesFindOne(Long empId);


    @WebMethod(action="/nl.amis.sdo.jpa.services/persistDepartmentsSDO",
        operationName="persistDepartmentsSDO")
    @RequestWrapper(targetNamespace="/nl.amis.sdo.jpa.services/",
        localName="persistDepartmentsSDO")
    @ResponseWrapper(targetNamespace="/nl.amis.sdo.jpa.services/",
        localName="persistDepartmentsSDOResponse")
    @WebResult(name="result")
    DepartmentsSDO persistDepartmentsSDO(@WebParam(mode = WebParam.Mode.IN,
            name="departmentsSDO") DepartmentsSDO departmentsSDO) throws RuntimeException;

    @WebMethod(action="/nl.amis.sdo.jpa.services/mergeDepartmentsSDO",
        operationName="mergeDepartmentsSDO")
    @RequestWrapper(targetNamespace="/nl.amis.sdo.jpa.services/",
        localName="mergeDepartmentsSDO")
    @ResponseWrapper(targetNamespace="/nl.amis.sdo.jpa.services/",
        localName="mergeDepartmentsSDOResponse")
    @WebResult(name="result")
    DepartmentsSDO mergeDepartmentsSDO(@WebParam(mode = WebParam.Mode.IN,
            name="departmentsSDO") DepartmentsSDO departmentsSDO) throws RuntimeException;

    @WebMethod(action="/nl.amis.sdo.jpa.services/removeDepartmentsSDO",
        operationName="removeDepartmentsSDO")
    @RequestWrapper(targetNamespace="/nl.amis.sdo.jpa.services/",
        localName="removeDepartmentsSDO")
    @ResponseWrapper(targetNamespace="/nl.amis.sdo.jpa.services/",
        localName="removeDepartmentsSDOResponse")
    void removeDepartmentsSDO(@WebParam(mode = WebParam.Mode.IN,
            name="departmentsSDO") DepartmentsSDO departmentsSDO) throws RuntimeException;

    @WebMethod(action="/nl.amis.sdo.jpa.services/getDepartmentsFindAllSDO",
        operationName="getDepartmentsFindAllSDO")
    @RequestWrapper(targetNamespace="/nl.amis.sdo.jpa.services/",
        localName="getDepartmentsFindAllSDO")
    @ResponseWrapper(targetNamespace="/nl.amis.sdo.jpa.services/",
        localName="getDepartmentsFindAllSDOResponse")
    @WebResult(name="result")
    List<DepartmentsSDO> getDepartmentsFindAllSDO() throws RuntimeException;

    @WebMethod(action="/nl.amis.sdo.jpa.services/getDepartmentsFindOneSDO",
        operationName="getDepartmentsFindOneSDO")
    @RequestWrapper(targetNamespace="/nl.amis.sdo.jpa.services/",
        localName="getDepartmentsFindOneSDO")
    @ResponseWrapper(targetNamespace="/nl.amis.sdo.jpa.services/",
        localName="getDepartmentsFindOneSDOResponse")
    @WebResult(name="result")
    List<DepartmentsSDO> getDepartmentsFindOneSDO(@WebParam(mode = WebParam.Mode.IN,
            name="deptId") Long deptId) throws RuntimeException;


}
