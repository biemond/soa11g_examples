
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:23:23 CEST)
 */

        
            package osb_cookbook.customermanagement;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://osb-cookbook/customer".equals(namespaceURI) &&
                  "CustomerTyp".equals(typeName)){
                   
                            return  osb_cookbook.customer.CustomerTyp.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://osb-cookbook/customer".equals(namespaceURI) &&
                  "AddressTyp".equals(typeName)){
                   
                            return  osb_cookbook.customer.AddressTyp.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://osb-cookbook/customer".equals(namespaceURI) &&
                  "RatingTyp".equals(typeName)){
                   
                            return  osb_cookbook.customer.RatingTyp.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://osb-cookbook/creditcard".equals(namespaceURI) &&
                  "CardIssuerTyp".equals(typeName)){
                   
                            return  osb_cookbook.creditcard.CardIssuerTyp.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://osb-cookbook/customer".equals(namespaceURI) &&
                  "AddressesTyp".equals(typeName)){
                   
                            return  osb_cookbook.customer.AddressesTyp.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://osb-cookbook/creditcard".equals(namespaceURI) &&
                  "CreditCardTyp".equals(typeName)){
                   
                            return  osb_cookbook.creditcard.CreditCardTyp.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    