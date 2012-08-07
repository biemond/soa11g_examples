package nl.amis.sdo.jpa.local;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import nl.amis.sdo.jpa.entities.Departments;
import nl.amis.sdo.jpa.entities.Employees;

public class JavaServiceFacade {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModelSDOLocal");

    public JavaServiceFacade() {
    }

    public static void main(String [] args) {
        final JavaServiceFacade javaServiceFacade = new JavaServiceFacade();
        //  TODO:  Call methods on javaServiceFacade here...
        List<Departments> departments = javaServiceFacade.getDepartmentsFindAll();
        for ( Departments department : departments ){
            System.out.print("dept id: "+department.getDepartmentId());
            System.out.println(" name: "+department.getDepartmentName());
            if ( department.getManager() != null ){
                System.out.println("manager: "+department.getManager().getLastName()); 
            }
            System.out.println("total employees: "+department.getEmployeesList().size());
        }
        
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = getEntityManager().createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    /** <code>select o from Departments o</code> */
    public List<Departments> getDepartmentsFindAll() {
        return getEntityManager().createNamedQuery("Departments.findAll").getResultList();
    }

    /** <code>select o from Employees o</code> */
    public List<Employees> getEmployeesFindAll() {
        return getEntityManager().createNamedQuery("Employees.findAll").getResultList();
    }
}
