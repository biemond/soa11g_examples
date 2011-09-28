
package nl.whitehorses.soa.model.hr.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getDepartmentsFindOneResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDepartmentsFindOneResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="department" type="{http://services.hr.model.soa.whitehorses.nl/}departments" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDepartmentsFindOneResponse", propOrder = {
    "department"
})
public class GetDepartmentsFindOneResponse {

    protected Departments department;

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link Departments }
     *     
     */
    public Departments getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link Departments }
     *     
     */
    public void setDepartment(Departments value) {
        this.department = value;
    }

}
