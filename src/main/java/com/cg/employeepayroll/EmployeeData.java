package com.cg.employeepayroll;

public class EmployeeData {
    private String name,id;
    private String salary;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }

    EmployeeData(String name, String id, String salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }

    public String toString(){
        return name + "\n" + id + "\n" + salary;
    }

}
