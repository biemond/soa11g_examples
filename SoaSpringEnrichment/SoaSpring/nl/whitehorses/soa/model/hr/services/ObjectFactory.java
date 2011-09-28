
package nl.whitehorses.soa.model.hr.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nl.whitehorses.soa.model.hr.services package. 
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

    private final static QName _GetDepartmentsFindOne_QNAME = new QName("http://services.hr.model.soa.whitehorses.nl/", "getDepartmentsFindOne");
    private final static QName _GetEmployeesFindOneResponse_QNAME = new QName("http://services.hr.model.soa.whitehorses.nl/", "getEmployeesFindOneResponse");
    private final static QName _GetDepartmentsFindOneResponse_QNAME = new QName("http://services.hr.model.soa.whitehorses.nl/", "getDepartmentsFindOneResponse");
    private final static QName _GetEmployeesFindOne_QNAME = new QName("http://services.hr.model.soa.whitehorses.nl/", "getEmployeesFindOne");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.whitehorses.soa.model.hr.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEmployeesFindOne }
     * 
     */
    public GetEmployeesFindOne createGetEmployeesFindOne() {
        return new GetEmployeesFindOne();
    }

    /**
     * Create an instance of {@link GetDepartmentsFindOneResponse }
     * 
     */
    public GetDepartmentsFindOneResponse createGetDepartmentsFindOneResponse() {
        return new GetDepartmentsFindOneResponse();
    }

    /**
     * Create an instance of {@link GetEmployeesFindOneResponse }
     * 
     */
    public GetEmployeesFindOneResponse createGetEmployeesFindOneResponse() {
        return new GetEmployeesFindOneResponse();
    }

    /**
     * Create an instance of {@link GetDepartmentsFindOne }
     * 
     */
    public GetDepartmentsFindOne createGetDepartmentsFindOne() {
        return new GetDepartmentsFindOne();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDepartmentsFindOne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.hr.model.soa.whitehorses.nl/", name = "getDepartmentsFindOne")
    public JAXBElement<GetDepartmentsFindOne> createGetDepartmentsFindOne(GetDepartmentsFindOne value) {
        return new JAXBElement<GetDepartmentsFindOne>(_GetDepartmentsFindOne_QNAME, GetDepartmentsFindOne.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeesFindOneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.hr.model.soa.whitehorses.nl/", name = "getEmployeesFindOneResponse")
    public JAXBElement<GetEmployeesFindOneResponse> createGetEmployeesFindOneResponse(GetEmployeesFindOneResponse value) {
        return new JAXBElement<GetEmployeesFindOneResponse>(_GetEmployeesFindOneResponse_QNAME, GetEmployeesFindOneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDepartmentsFindOneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.hr.model.soa.whitehorses.nl/", name = "getDepartmentsFindOneResponse")
    public JAXBElement<GetDepartmentsFindOneResponse> createGetDepartmentsFindOneResponse(GetDepartmentsFindOneResponse value) {
        return new JAXBElement<GetDepartmentsFindOneResponse>(_GetDepartmentsFindOneResponse_QNAME, GetDepartmentsFindOneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeesFindOne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.hr.model.soa.whitehorses.nl/", name = "getEmployeesFindOne")
    public JAXBElement<GetEmployeesFindOne> createGetEmployeesFindOne(GetEmployeesFindOne value) {
        return new JAXBElement<GetEmployeesFindOne>(_GetEmployeesFindOne_QNAME, GetEmployeesFindOne.class, null, value);
    }

}
