package com.cg.employeepayroll;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollMain {
    public static void main(String[] args) throws IOException {
        
        ArrayList<EmployeeData> employeeDataArrayList = new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        EmployeePayrollMain employeePayrollMain = new EmployeePayrollMain();
        employeeDataArrayList.add(employeePayrollMain.readEmployeeData(sc));
        employeePayrollMain.writeEmployeeData(employeeDataArrayList);
    }

    public EmployeeData readEmployeeData(Scanner sc){
        System.out.println("Enter your name");
        String name=sc.nextLine();
        System.out.println("Enter your id");
        String id=sc.nextLine();
        System.out.println("Enter your salary");
        String salary = sc.nextLine();
        return new EmployeeData(name,id,salary);
    }
    public void writeEmployeeData(List<EmployeeData
                > employeeDataList) throws IOException {
        System.out.println("\nWriting Employee Roaster to Console\n" + employeeDataList);
    }
}
