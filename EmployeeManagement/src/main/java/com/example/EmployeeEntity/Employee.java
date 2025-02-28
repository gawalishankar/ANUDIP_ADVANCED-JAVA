package com.example.EmployeeEntity;

public class Employee {
    private Long id;
    private String name;
    private String department;
    private String role;
    private Long salary;

    // ✅ Default constructor (required for JSON deserialization)
    public Employee() {}

    // ✅ Parameterized constructor
    public Employee(Long id, String name, String department, String role, Long salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
