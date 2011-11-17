package nl.whitehorses.soa.model.hr.services;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import nl.whitehorses.soa.model.hr.entities.Departments;
import nl.whitehorses.soa.model.hr.entities.Employees;

@Stateless(name = "HrModelSessionEJB", mappedName = "HrModelSessionEJB")
@Remote
@WebService(name = "HrSessionBeanService", portName = "HrSessionBeanServicePort")
public class HrSessionBean implements HrModelSessionEJB {
    @PersistenceContext(unitName="HrModel")
    private EntityManager em;

    public HrSessionBean() {
    }

    @WebMethod(exclude = true)
    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public Employees createEmployee( Employees employee ) {
        em.persist(employee);
        return employee;
    }


    /** <code>select o from Employees o</code> */
    @WebMethod(exclude = true)
    public List<Employees> getEmployeesFindAll() {
        return em.createNamedQuery("Employees.findAll").getResultList();
    }

    /** <code>select o from Employees o where o.employeeId = :empId</code> */
   @WebMethod
   @WebResult(name = "employee")
    public Employees getEmployeesFindOne(@WebParam(name = "empId") long empId) {
        return (Employees)em.createNamedQuery("Employees.findOne").setParameter("empId", empId).getSingleResult();
    }

    /** <code>select o from Departments o</code> */
    @WebMethod(exclude = true)
    public List<Departments> getDepartmentsFindAll() {
        return em.createNamedQuery("Departments.findAll").getResultList();
    }

    /** <code>select o from Departments o where o.departmentId = :deptId</code> */
    @WebMethod
    @WebResult(name = "department")
    public Departments getDepartmentsFindOne(@WebParam(name = "deptId") long deptId) {
        return (Departments)em.createNamedQuery("Departments.findOne").setParameter("deptId", deptId).getSingleResult();
    }
}
