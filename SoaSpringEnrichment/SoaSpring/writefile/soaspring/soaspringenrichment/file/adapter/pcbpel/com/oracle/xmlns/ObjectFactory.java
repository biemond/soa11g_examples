
package writefile.soaspring.soaspringenrichment.file.adapter.pcbpel.com.oracle.xmlns;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the writefile.soaspring.soaspringenrichment.file.adapter.pcbpel.com.oracle.xmlns package. 
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

    private final static QName _OpaqueElement_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/opaque/", "opaqueElement");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: writefile.soaspring.soaspringenrichment.file.adapter.pcbpel.com.oracle.xmlns
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/opaque/", name = "opaqueElement")
    public JAXBElement<byte[]> createOpaqueElement(byte[] value) {
        return new JAXBElement<byte[]>(_OpaqueElement_QNAME, byte[].class, null, ((byte[]) value));
    }

}
