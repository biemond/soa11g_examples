package nl.amis.sdo.jpa;

import commonj.sdo.helper.XSDHelper;

import java.util.Hashtable;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import nl.amis.sdo.jpa.entities.DepartmentsSDO;
import nl.amis.sdo.jpa.services.HrSessionEJB;

public class HrSessionEJBClientSDO {
    public HrSessionEJBClientSDO() {
    }

    public static void main(String[] args) {
        try {
            ClassLoader loader =
                Thread.currentThread().getContextClassLoader();
            XSDHelper.INSTANCE.define(loader.getResourceAsStream("nl/amis/sdo/jpa/entities/EmployeesSDO.xsd"),
                                      "nl/amis/sdo/jpa/entities/");
            XSDHelper.INSTANCE.define(loader.getResourceAsStream("nl/amis/sdo/jpa/entities/DepartmentsSDO.xsd"),
                                      "nl/amis/sdo/jpa/entities/");
            XSDHelper.INSTANCE.define(loader.getResourceAsStream("nl/amis/sdo/jpa/services/HrSessionEJBBeanWS.xsd"),
                                      "nl/amis/sdo/jpa/services/");

            final Context context = getInitialContext();
            HrSessionEJB hrSessionEJB =
                (HrSessionEJB)context.lookup("EjbSdoService-HrSessionEJB#nl.amis.sdo.jpa.services.HrSessionEJB");
            for (DepartmentsSDO departments :
                 (List<DepartmentsSDO>)hrSessionEJB.getDepartmentsFindAllSDO()) {
                printDepartments(departments);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printDepartments(DepartmentsSDO departments) {
        System.out.println("departmentId = " + departments.getDepartmentId());
        System.out.println("departmentName = " +
                           departments.getDepartmentName());
        System.out.println("locationId = " + departments.getLocationId());
        System.out.println("employeesList = " +
                           departments.getEmployeesList());
        System.out.println("manager = " + departments.getManager());
    }


    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://soaps5:8001");
        return new InitialContext(env);
    }

}
