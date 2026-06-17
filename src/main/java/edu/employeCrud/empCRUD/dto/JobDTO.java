package edu.employeCrud.empCRUD.dto;

import java.util.List;

public class JobDTO {

    private Integer id;
    private String title;
    private String mode;
    private List<EmployeeDTO> employees;

    public JobDTO() {
    }

    public JobDTO(Integer id, String title, String mode, List<EmployeeDTO> employees) {
        this.id = id;
        this.title = title;
        this.mode = mode;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
