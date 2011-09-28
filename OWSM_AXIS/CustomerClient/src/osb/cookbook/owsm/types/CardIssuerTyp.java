
package osb.cookbook.owsm.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardIssuerTyp.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CardIssuerTyp">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="visa"/>
 *     &lt;enumeration value="amexco"/>
 *     &lt;enumeration value="mastercard"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CardIssuerTyp", namespace = "http://osb-cookbook/creditcard")
@XmlEnum
public enum CardIssuerTyp {

    @XmlEnumValue("visa")
    VISA("visa"),
    @XmlEnumValue("amexco")
    AMEXCO("amexco"),
    @XmlEnumValue("mastercard")
    MASTERCARD("mastercard");
    private final String value;

    CardIssuerTyp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CardIssuerTyp fromValue(String v) {
        for (CardIssuerTyp c: CardIssuerTyp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
