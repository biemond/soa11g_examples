
package nl.amis.ws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DepartmentsCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DepartmentsCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Departments" type="{http://www.amis.nl/front/ebo}Departments" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DepartmentsCollection", propOrder = {
    "departments"
})
public class DepartmentsCollection {

    @XmlElement(name = "Departments")
    protected List<Departments> departments;

    /**
     * Gets the value of the departments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the departments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDepartments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Departments }
     * 
     * 
     */
    public List<Departments> getDepartments() {
        if (departments == null) {
            departments = new ArrayList<Departments>();
        }
        return this.departments;
    }

}
