package nl.amis.sdo.jpa;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.naming.NamingException;

import nl.amis.sdo.jpa.entities.Departments;
import nl.amis.sdo.jpa.entities.Employees;
import nl.amis.sdo.jpa.services.HrSessionEJB;

public class HrSessionEJBClient {
    public static void main(String [] args) {
        try {
            final Context context = getInitialContext();
            HrSessionEJB hrSessionEJB = (HrSessionEJB)context.lookup("EjbSdoService-HrSessionEJB#nl.amis.sdo.jpa.services.HrSessionEJB");
            for (Departments departments : (List<Departments>)hrSessionEJB.getDepartmentsFindAll()) {
                printDepartments(departments);
            }
            for (Departments departments : (List<Departments>)hrSessionEJB.getDepartmentsFindOne(10L )) {
                printDepartments(departments);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printDepartments(Departments departments) {
        System.out.println( "departmentId = " + departments.getDepartmentId() );
        System.out.println( "departmentName = " + departments.getDepartmentName() );
        System.out.println( "locationId = " + departments.getLocationId() );
        System.out.println( "employeesList = " + departments.getEmployeesList() );
        System.out.println( "manager = " + departments.getManager() );
    }

    private static void printEmployees(Employees employees) {
        System.out.println( "commissionPct = " + employees.getCommissionPct() );
        System.out.println( "email = " + employees.getEmail() );
        System.out.println( "employeeId = " + employees.getEmployeeId() );
        System.out.println( "firstName = " + employees.getFirstName() );
        System.out.println( "hireDate = " + employees.getHireDate() );
        System.out.println( "jobId = " + employees.getJobId() );
        System.out.println( "lastName = " + employees.getLastName() );
        System.out.println( "phoneNumber = " + employees.getPhoneNumber() );
        System.out.println( "salary = " + employees.getSalary() );
        System.out.println( "departments = " + employees.getDepartments() );
        System.out.println( "managerId = " + employees.getManagerId() );
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://soaps5:8001");
        return new InitialContext( env );
    }
}
