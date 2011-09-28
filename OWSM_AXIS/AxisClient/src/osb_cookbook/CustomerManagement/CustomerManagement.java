/**
 * CustomerManagement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package osb_cookbook.CustomerManagement;

public interface CustomerManagement extends java.rmi.Remote {
    public osb_cookbook.customer.CustomerTyp findCustomer(long ID) throws java.rmi.RemoteException;
}
