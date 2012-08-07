package nl.amis.sdo.jpa.entities;

import org.eclipse.persistence.sdo.SDODataObject;

public class EmployeesSDOImpl extends SDODataObject implements EmployeesSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 9;

   public EmployeesSDOImpl() {}

   public double getCommissionPct() {
      return getDouble(START_PROPERTY_INDEX + 0);
   }

   public void setCommissionPct(double value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

   public java.lang.String getEmail() {
      return getString(START_PROPERTY_INDEX + 1);
   }

   public void setEmail(java.lang.String value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }

   public long getEmployeeId() {
      return getLong(START_PROPERTY_INDEX + 2);
   }

   public void setEmployeeId(long value) {
      set(START_PROPERTY_INDEX + 2 , value);
   }

   public java.lang.String getFirstName() {
      return getString(START_PROPERTY_INDEX + 3);
   }

   public void setFirstName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 3 , value);
   }

   public java.util.Date getHireDate() {
      return getDate(START_PROPERTY_INDEX + 4);
   }

   public void setHireDate(java.util.Date value) {
      set(START_PROPERTY_INDEX + 4 , value);
   }

   public java.lang.String getJobId() {
      return getString(START_PROPERTY_INDEX + 5);
   }

   public void setJobId(java.lang.String value) {
      set(START_PROPERTY_INDEX + 5 , value);
   }

   public java.lang.String getLastName() {
      return getString(START_PROPERTY_INDEX + 6);
   }

   public void setLastName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 6 , value);
   }

   public long getManagerId() {
      return getLong(START_PROPERTY_INDEX + 7);
   }

   public void setManagerId(long value) {
      set(START_PROPERTY_INDEX + 7 , value);
   }

   public java.lang.String getPhoneNumber() {
      return getString(START_PROPERTY_INDEX + 8);
   }

   public void setPhoneNumber(java.lang.String value) {
      set(START_PROPERTY_INDEX + 8 , value);
   }

   public double getSalary() {
      return getDouble(START_PROPERTY_INDEX + 9);
   }

   public void setSalary(double value) {
      set(START_PROPERTY_INDEX + 9 , value);
   }


}

