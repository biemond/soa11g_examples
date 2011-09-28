
package nl.whitehorses.soa.model.hr.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getDepartmentsFindOne complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDepartmentsFindOne">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deptId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDepartmentsFindOne", propOrder = {
    "deptId"
})
public class GetDepartmentsFindOne {

    protected long deptId;

    /**
     * Gets the value of the deptId property.
     * 
     */
    public long getDeptId() {
        return deptId;
    }

    /**
     * Sets the value of the deptId property.
     * 
     */
    public void setDeptId(long value) {
        this.deptId = value;
    }

}
