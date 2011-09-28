
package osb.cookbook.owsm.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreditCardTyp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditCardTyp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardIssuer" type="{http://osb-cookbook/creditcard}CardIssuerTyp"/>
 *         &lt;element name="CardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CardholderName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CardValidationCode" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditCardTyp", namespace = "http://osb-cookbook/creditcard", propOrder = {
    "cardIssuer",
    "cardNumber",
    "cardholderName",
    "expirationDate",
    "cardValidationCode"
})
public class CreditCardTyp {

    @XmlElement(name = "CardIssuer", required = true)
    protected CardIssuerTyp cardIssuer;
    @XmlElement(name = "CardNumber", required = true)
    protected String cardNumber;
    @XmlElement(name = "CardholderName", required = true)
    protected String cardholderName;
    @XmlElement(name = "ExpirationDate", required = true)
    protected String expirationDate;
    @XmlElement(name = "CardValidationCode")
    protected long cardValidationCode;

    /**
     * Gets the value of the cardIssuer property.
     * 
     * @return
     *     possible object is
     *     {@link CardIssuerTyp }
     *     
     */
    public CardIssuerTyp getCardIssuer() {
        return cardIssuer;
    }

    /**
     * Sets the value of the cardIssuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardIssuerTyp }
     *     
     */
    public void setCardIssuer(CardIssuerTyp value) {
        this.cardIssuer = value;
    }

    /**
     * Gets the value of the cardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the cardholderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardholderName() {
        return cardholderName;
    }

    /**
     * Sets the value of the cardholderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardholderName(String value) {
        this.cardholderName = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpirationDate(String value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the cardValidationCode property.
     * 
     */
    public long getCardValidationCode() {
        return cardValidationCode;
    }

    /**
     * Sets the value of the cardValidationCode property.
     * 
     */
    public void setCardValidationCode(long value) {
        this.cardValidationCode = value;
    }

}
