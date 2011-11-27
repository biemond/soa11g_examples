
package nl.amis.ws.types;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nl.amis.ws.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EmployeesCollection_QNAME = new QName("http://www.amis.nl/front/ebo", "EmployeesCollection");
    private final static QName _BusinessFault_QNAME = new QName("http://www.customfaults.org", "BusinessFault");
    private final static QName _InputParameters_QNAME = new QName("http://www.amis.nl/front/ebo", "InputParameters");
    private final static QName _DepartmentsCollection_QNAME = new QName("http://www.amis.nl/front/ebo", "DepartmentsCollection");
    private final static QName _InputDepartment_QNAME = new QName("http://www.amis.nl/front/ebo", "InputDepartment");
    private final static QName _Department_QNAME = new QName("http://www.amis.nl/front/ebo", "Department");
    private final static QName _EmployeesManagerId_QNAME = new QName("http://www.amis.nl/front/ebo", "managerId");
    private final static QName _EmployeesPhoneNumber_QNAME = new QName("http://www.amis.nl/front/ebo", "phoneNumber");
    private final static QName _EmployeesFirstName_QNAME = new QName("http://www.amis.nl/front/ebo", "firstName");
    private final static QName _EmployeesDepartmentId_QNAME = new QName("http://www.amis.nl/front/ebo", "departmentId");
    private final static QName _EmployeesCommissionPct_QNAME = new QName("http://www.amis.nl/front/ebo", "commissionPct");
    private final static QName _EmployeesSalary_QNAME = new QName("http://www.amis.nl/front/ebo", "salary");
    private final static QName _DepartmentsLocationId_QNAME = new QName("http://www.amis.nl/front/ebo", "locationId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.amis.ws.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DepartmentsCollection }
     * 
     */
    public DepartmentsCollection createDepartmentsCollection() {
        return new DepartmentsCollection();
    }

    /**
     * Create an instance of {@link InputParametersType }
     * 
     */
    public InputParametersType createInputParametersType() {
        return new InputParametersType();
    }

    /**
     * Create an instance of {@link InputDepartmentType }
     * 
     */
    public InputDepartmentType createInputDepartmentType() {
        return new InputDepartmentType();
    }

    /**
     * Create an instance of {@link EmployeesCollection }
     * 
     */
    public EmployeesCollection createEmployeesCollection() {
        return new EmployeesCollection();
    }

    /**
     * Create an instance of {@link Departments }
     * 
     */
    public Departments createDepartments() {
        return new Departments();
    }

    /**
     * Create an instance of {@link Employees }
     * 
     */
    public Employees createEmployees() {
        return new Employees();
    }

    /**
     * Create an instance of {@link FaultType }
     * 
     */
    public FaultType createFaultType() {
        return new FaultType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeesCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.amis.nl/front/ebo", name = "EmployeesCollection")
    public JAXBElement<EmployeesCollection> createEmployeesCollection(EmployeesCollection value) {
        return new JAXBElement<EmployeesCollection>(_EmployeesCollection_QNAME, EmployeesCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.customfaults.org", name = "BusinessFault")
    public JAXBElement<FaultType> createBusinessFault(FaultType value) {
        return new JAXBElement<FaultType>(_BusinessFault_QNAME, FaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputParametersType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.amis.nl/front/ebo", name = "InputParameters")
    public JAXBElement<InputParametersType> createInputParameters(InputParametersType value) {
        return new JAXBElement<InputParametersType>(_InputParameters_QNAME, InputParametersType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepartmentsCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.amis.nl/front/ebo", name = "DepartmentsCollection")
    public JAXBElement<DepartmentsCollection> createDepartmentsCollection(DepartmentsCollection value) {
        return new JAXBElement<DepartmentsCollection>(_DepartmentsCollection_QNAME, DepartmentsCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputDepartmentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.amis.nl/front/ebo", name = "InputDepartment")
    public JAXBElement<InputDepartmentType> createInputDepartment(InputDepartmentType value) {
        return new JAXBElement<InputDepartmentType>(_InputDepartment_QNAME, InputDepartmentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Departments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.amis.nl/front/ebo", name = "Department")
    public JAXBElement<Departments> createDepartment(Departments value) {
        return new JAXBElement<Departments>(_Department_QNAME, Departments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.amis.nl/front/ebo", name = "managerId", scope = Employees.class)
    public JAXBElement<Integer> createEmployeesManagerId(Integer value) {
        return new JAXBElement<Integer>(_EmployeesManagerId_QNAME, Integer.class, Employees.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.amis.nl/front/ebo", name = "phoneNumber", scope = Employees.class)
    public JAXBElement<String> createEmployeesPhoneNumber(String value) {
        return new JAXBElement<String>(_EmployeesPhoneNumber_QNAME, String.class, Employees.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.amis.nl/front/ebo", name = "firstName", scope = Employees.class)
    public JAXBElement<String> createEmployeesFirstName(String value) {
        return new JAXBElement<String>(_EmployeesFirstName_QNAME, String.class, Employees.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.amis.nl/front/ebo", name = "departmentId", scope = Employees.class)
    public JAXBElement<Integer> createEmployeesDepartmentId(Integer value) {
        return new JAXBElement<Integer>(_EmployeesDepartmentId_QNAME, Integer.class, Employees.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.amis.nl/front/ebo", name = "commissionPct", scope = Employees.class)
    public JAXBElement<BigDecimal> createEmployeesCommissionPct(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_EmployeesCommissionPct_QNAME, BigDecimal.class, Employees.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.amis.nl/front/ebo", name = "salary", scope = Employees.class)
    public JAXBElement<BigDecimal> createEmployeesSalary(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_EmployeesSalary_QNAME, BigDecimal.class, Employees.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.amis.nl/front/ebo", name = "managerId", scope = Departments.class)
    public JAXBElement<Integer> createDepartmentsManagerId(Integer value) {
        return new JAXBElement<Integer>(_EmployeesManagerId_QNAME, Integer.class, Departments.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.amis.nl/front/ebo", name = "locationId", scope = Departments.class)
    public JAXBElement<Integer> createDepartmentsLocationId(Integer value) {
        return new JAXBElement<Integer>(_DepartmentsLocationId_QNAME, Integer.class, Departments.class, value);
    }

}
