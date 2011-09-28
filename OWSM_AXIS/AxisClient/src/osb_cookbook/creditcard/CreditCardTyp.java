/**
 * CreditCardTyp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package osb_cookbook.creditcard;

public class CreditCardTyp  implements java.io.Serializable {
    private osb_cookbook.creditcard.CardIssuerTyp cardIssuer;

    private java.lang.String cardNumber;

    private java.lang.String cardholderName;

    private java.lang.String expirationDate;

    private long cardValidationCode;

    public CreditCardTyp() {
    }

    public CreditCardTyp(
           osb_cookbook.creditcard.CardIssuerTyp cardIssuer,
           java.lang.String cardNumber,
           java.lang.String cardholderName,
           java.lang.String expirationDate,
           long cardValidationCode) {
           this.cardIssuer = cardIssuer;
           this.cardNumber = cardNumber;
           this.cardholderName = cardholderName;
           this.expirationDate = expirationDate;
           this.cardValidationCode = cardValidationCode;
    }


    /**
     * Gets the cardIssuer value for this CreditCardTyp.
     * 
     * @return cardIssuer
     */
    public osb_cookbook.creditcard.CardIssuerTyp getCardIssuer() {
        return cardIssuer;
    }


    /**
     * Sets the cardIssuer value for this CreditCardTyp.
     * 
     * @param cardIssuer
     */
    public void setCardIssuer(osb_cookbook.creditcard.CardIssuerTyp cardIssuer) {
        this.cardIssuer = cardIssuer;
    }


    /**
     * Gets the cardNumber value for this CreditCardTyp.
     * 
     * @return cardNumber
     */
    public java.lang.String getCardNumber() {
        return cardNumber;
    }


    /**
     * Sets the cardNumber value for this CreditCardTyp.
     * 
     * @param cardNumber
     */
    public void setCardNumber(java.lang.String cardNumber) {
        this.cardNumber = cardNumber;
    }


    /**
     * Gets the cardholderName value for this CreditCardTyp.
     * 
     * @return cardholderName
     */
    public java.lang.String getCardholderName() {
        return cardholderName;
    }


    /**
     * Sets the cardholderName value for this CreditCardTyp.
     * 
     * @param cardholderName
     */
    public void setCardholderName(java.lang.String cardholderName) {
        this.cardholderName = cardholderName;
    }


    /**
     * Gets the expirationDate value for this CreditCardTyp.
     * 
     * @return expirationDate
     */
    public java.lang.String getExpirationDate() {
        return expirationDate;
    }


    /**
     * Sets the expirationDate value for this CreditCardTyp.
     * 
     * @param expirationDate
     */
    public void setExpirationDate(java.lang.String expirationDate) {
        this.expirationDate = expirationDate;
    }


    /**
     * Gets the cardValidationCode value for this CreditCardTyp.
     * 
     * @return cardValidationCode
     */
    public long getCardValidationCode() {
        return cardValidationCode;
    }


    /**
     * Sets the cardValidationCode value for this CreditCardTyp.
     * 
     * @param cardValidationCode
     */
    public void setCardValidationCode(long cardValidationCode) {
        this.cardValidationCode = cardValidationCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreditCardTyp)) return false;
        CreditCardTyp other = (CreditCardTyp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cardIssuer==null && other.getCardIssuer()==null) || 
             (this.cardIssuer!=null &&
              this.cardIssuer.equals(other.getCardIssuer()))) &&
            ((this.cardNumber==null && other.getCardNumber()==null) || 
             (this.cardNumber!=null &&
              this.cardNumber.equals(other.getCardNumber()))) &&
            ((this.cardholderName==null && other.getCardholderName()==null) || 
             (this.cardholderName!=null &&
              this.cardholderName.equals(other.getCardholderName()))) &&
            ((this.expirationDate==null && other.getExpirationDate()==null) || 
             (this.expirationDate!=null &&
              this.expirationDate.equals(other.getExpirationDate()))) &&
            this.cardValidationCode == other.getCardValidationCode();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCardIssuer() != null) {
            _hashCode += getCardIssuer().hashCode();
        }
        if (getCardNumber() != null) {
            _hashCode += getCardNumber().hashCode();
        }
        if (getCardholderName() != null) {
            _hashCode += getCardholderName().hashCode();
        }
        if (getExpirationDate() != null) {
            _hashCode += getExpirationDate().hashCode();
        }
        _hashCode += new Long(getCardValidationCode()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreditCardTyp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://osb-cookbook/creditcard", "CreditCardTyp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardIssuer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osb-cookbook/creditcard", "CardIssuer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://osb-cookbook/creditcard", "CardIssuerTyp"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osb-cookbook/creditcard", "CardNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardholderName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osb-cookbook/creditcard", "CardholderName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expirationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osb-cookbook/creditcard", "ExpirationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardValidationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osb-cookbook/creditcard", "CardValidationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
