package nl.amis.sdo.jpa.entities;

public interface DepartmentsSDO {

   public long getDepartmentId();

   public void setDepartmentId(long value);

   public java.lang.String getDepartmentName();

   public void setDepartmentName(java.lang.String value);

   public java.util.List getEmployeesList();

   public void setEmployeesList(java.util.List value);

   public long getLocationId();

   public void setLocationId(long value);

   public nl.amis.sdo.jpa.entities.EmployeesSDO getManager();

   public void setManager(nl.amis.sdo.jpa.entities.EmployeesSDO value);


}

