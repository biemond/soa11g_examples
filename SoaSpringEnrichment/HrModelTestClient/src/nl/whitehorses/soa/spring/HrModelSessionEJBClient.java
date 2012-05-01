package nl.whitehorses.soa.spring;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.naming.NamingException;

import nl.whitehorses.soa.model.hr.entities.Departments;
import nl.whitehorses.soa.model.hr.entities.Employees;
import nl.whitehorses.soa.model.hr.services.HrModelSessionEJB;

public class HrModelSessionEJBClient {
    public static void main(String [] args) {
        try {
            final Context context = getInitialContext();
            HrModelSessionEJB hrModelSessionEJB = (HrModelSessionEJB)context.lookup("HrModelSessionEJB#nl.whitehorses.soa.model.hr.services.HrModelSessionEJB");
//            for (Employees employees : (List<Employees>)hrModelSessionEJB.getEmployeesFindAll()) {
//                printEmployees(employees);
//            }
            for (Departments departments : (List<Departments>)hrModelSessionEJB.getDepartmentsFindAll()) {
                printDepartments(departments);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printEmployees(Employees employees) {
        System.out.println( "commissionPct = " + employees.getCommissionPct() );
        System.out.println( "email = " + employees.getEmail() );
        System.out.println( "employeeId = " + employees.getEmployeeId() );
        System.out.println( "firstName = " + employees.getFirstName() );
        System.out.println( "jobId = " + employees.getJobId() );
        System.out.println( "lastName = " + employees.getLastName() );
        System.out.println( "phoneNumber = " + employees.getPhoneNumber() );
        System.out.println( "salary = " + employees.getSalary() );

    }

    private static void printDepartments(Departments departments) {
        System.out.println( "departmentId = " + departments.getDepartmentId() );
        System.out.println( "departmentName = " + departments.getDepartmentName() );
        System.out.println( "locationId = " + departments.getLocationId() );
        System.out.println( "managerId = " + departments.getManagerId() );
        
        for ( Employees employee : departments.getEmployees() ) {
          printEmployees(employee);
        }
        
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://soaps5:8001");
        return new InitialContext( env );
    }
}
