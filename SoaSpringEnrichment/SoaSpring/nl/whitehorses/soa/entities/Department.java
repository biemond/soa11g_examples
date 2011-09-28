package nl.whitehorses.soa.entities;

public class Department {
    public Department() {
    }

    private Integer departmentId;
    private String name;


    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
