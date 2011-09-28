
package osb.cookbook.owsm.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RatingTyp.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RatingTyp">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="AA"/>
 *     &lt;enumeration value="AAA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RatingTyp")
@XmlEnum
public enum RatingTyp {

    A,
    AA,
    AAA;

    public String value() {
        return name();
    }

    public static RatingTyp fromValue(String v) {
        return valueOf(v);
    }

}
