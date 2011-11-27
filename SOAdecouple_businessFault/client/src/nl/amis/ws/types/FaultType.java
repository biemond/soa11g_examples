
package nl.amis.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FaultCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FaultDesciption" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultType", namespace = "http://www.customfaults.org", propOrder = {
    "faultCode",
    "faultDesciption"
})
public class FaultType {

    @XmlElement(name = "FaultCode", required = true)
    protected String faultCode;
    @XmlElement(name = "FaultDesciption", required = true)
    protected String faultDesciption;

    /**
     * Gets the value of the faultCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultCode() {
        return faultCode;
    }

    /**
     * Sets the value of the faultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultCode(String value) {
        this.faultCode = value;
    }

    /**
     * Gets the value of the faultDesciption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultDesciption() {
        return faultDesciption;
    }

    /**
     * Sets the value of the faultDesciption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultDesciption(String value) {
        this.faultDesciption = value;
    }

}
