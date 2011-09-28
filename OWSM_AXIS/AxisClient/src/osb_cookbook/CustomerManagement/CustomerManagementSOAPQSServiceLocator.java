/**
 * CustomerManagementSOAPQSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package osb_cookbook.CustomerManagement;

public class CustomerManagementSOAPQSServiceLocator extends org.apache.axis.client.Service implements osb_cookbook.CustomerManagement.CustomerManagementSOAPQSService {

    public CustomerManagementSOAPQSServiceLocator() {
    }


    public CustomerManagementSOAPQSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CustomerManagementSOAPQSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CustomerManagementSOAPQSPort
    private java.lang.String CustomerManagementSOAPQSPort_address = "http://SOAPS3.alfa.local:8011/01_Securing-an-OSB-service/proxy/Customer";

    public java.lang.String getCustomerManagementSOAPQSPortAddress() {
        return CustomerManagementSOAPQSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CustomerManagementSOAPQSPortWSDDServiceName = "CustomerManagementSOAPQSPort";

    public java.lang.String getCustomerManagementSOAPQSPortWSDDServiceName() {
        return CustomerManagementSOAPQSPortWSDDServiceName;
    }

    public void setCustomerManagementSOAPQSPortWSDDServiceName(java.lang.String name) {
        CustomerManagementSOAPQSPortWSDDServiceName = name;
    }

    public osb_cookbook.CustomerManagement.CustomerManagement getCustomerManagementSOAPQSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CustomerManagementSOAPQSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCustomerManagementSOAPQSPort(endpoint);
    }

    public osb_cookbook.CustomerManagement.CustomerManagement getCustomerManagementSOAPQSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            osb_cookbook.CustomerManagement.CustomerManagementSOAPStub _stub = new osb_cookbook.CustomerManagement.CustomerManagementSOAPStub(portAddress, this);
            _stub.setPortName(getCustomerManagementSOAPQSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCustomerManagementSOAPQSPortEndpointAddress(java.lang.String address) {
        CustomerManagementSOAPQSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (osb_cookbook.CustomerManagement.CustomerManagement.class.isAssignableFrom(serviceEndpointInterface)) {
                osb_cookbook.CustomerManagement.CustomerManagementSOAPStub _stub = new osb_cookbook.CustomerManagement.CustomerManagementSOAPStub(new java.net.URL(CustomerManagementSOAPQSPort_address), this);
                _stub.setPortName(getCustomerManagementSOAPQSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CustomerManagementSOAPQSPort".equals(inputPortName)) {
            return getCustomerManagementSOAPQSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://osb-cookbook/CustomerManagement", "CustomerManagementSOAPQSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://osb-cookbook/CustomerManagement", "CustomerManagementSOAPQSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CustomerManagementSOAPQSPort".equals(portName)) {
            setCustomerManagementSOAPQSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
