package nl.whitehorses.soa.model.hr.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
  @NamedQuery(name = "Departments.findAll", query = "select o from Departments o")
, @NamedQuery(name = "Departments.findOne", query = "select o from Departments o where o.departmentId = :deptId")  
})
public class Departments implements Serializable {
    @Id
    @Column(name="DEPARTMENT_ID", nullable = false)
    private Long departmentId;
    @Column(name="DEPARTMENT_NAME", nullable = false, length = 30)
    private String departmentName;
    @Column(name="LOCATION_ID")
    private Long locationId;
    @Column(name="MANAGER_ID")
    private Long managerId;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "department", targetEntity =
            Employees.class)
    private List<Employees> employees;

    public Departments() {
    }


    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public List<Employees> getEmployees() {
        return employees;
    }
}
