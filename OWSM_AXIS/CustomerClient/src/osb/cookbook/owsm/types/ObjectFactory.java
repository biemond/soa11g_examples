
package osb.cookbook.owsm.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the osb.cookbook.owsm.types package. 
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

    private final static QName _CreditCard_QNAME = new QName("http://osb-cookbook/creditcard", "CreditCard");
    private final static QName _Customer_QNAME = new QName("http://osb-cookbook/customer", "Customer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: osb.cookbook.owsm.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindCustomerResponse }
     * 
     */
    public FindCustomerResponse createFindCustomerResponse() {
        return new FindCustomerResponse();
    }

    /**
     * Create an instance of {@link CustomerTyp }
     * 
     */
    public CustomerTyp createCustomerTyp() {
        return new CustomerTyp();
    }

    /**
     * Create an instance of {@link FindCustomer }
     * 
     */
    public FindCustomer createFindCustomer() {
        return new FindCustomer();
    }

    /**
     * Create an instance of {@link AddressesTyp }
     * 
     */
    public AddressesTyp createAddressesTyp() {
        return new AddressesTyp();
    }

    /**
     * Create an instance of {@link AddressTyp }
     * 
     */
    public AddressTyp createAddressTyp() {
        return new AddressTyp();
    }

    /**
     * Create an instance of {@link CreditCardTyp }
     * 
     */
    public CreditCardTyp createCreditCardTyp() {
        return new CreditCardTyp();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditCardTyp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://osb-cookbook/creditcard", name = "CreditCard")
    public JAXBElement<CreditCardTyp> createCreditCard(CreditCardTyp value) {
        return new JAXBElement<CreditCardTyp>(_CreditCard_QNAME, CreditCardTyp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerTyp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://osb-cookbook/customer", name = "Customer")
    public JAXBElement<CustomerTyp> createCustomer(CustomerTyp value) {
        return new JAXBElement<CustomerTyp>(_Customer_QNAME, CustomerTyp.class, null, value);
    }

}
