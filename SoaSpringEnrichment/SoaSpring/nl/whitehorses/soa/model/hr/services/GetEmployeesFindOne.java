
package nl.whitehorses.soa.model.hr.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getEmployeesFindOne complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getEmployeesFindOne">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="empId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEmployeesFindOne", propOrder = {
    "empId"
})
public class GetEmployeesFindOne {

    protected long empId;

    /**
     * Gets the value of the empId property.
     * 
     */
    public long getEmpId() {
        return empId;
    }

    /**
     * Sets the value of the empId property.
     * 
     */
    public void setEmpId(long value) {
        this.empId = value;
    }

}
