package osb.cookbook.owsm;

import java.net.MalformedURLException;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import osb_cookbook.CustomerManagement.CustomerManagement;
import osb_cookbook.CustomerManagement.CustomerManagementSOAPQSService;
import osb_cookbook.CustomerManagement.CustomerManagementSOAPQSServiceLocator;

import osb_cookbook.customer.CustomerTyp;


public class Test {

  public static void main(String [] args) throws MalformedURLException,
                                                  ServiceException,
                                                  RemoteException {
    System.setProperty("axis.ClientConfigFile", 
                       "./client_deployment.wsdd");

    CustomerManagementSOAPQSService service = new CustomerManagementSOAPQSServiceLocator();
    CustomerManagement cust = service.getCustomerManagementSOAPQSPort();
    CustomerTyp result = cust.findCustomer(100L);
    System.out.println(result.getLastName());
    
  }

}
