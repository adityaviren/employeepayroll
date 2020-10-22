package com.cg.employeepayroll;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollMain {

    public enum IOService {CONSOLE_IO,FILE_IO,DB_IO,REST_IO};

    private List<EmployeeData> employeePayrollList;

    public EmployeePayrollMain(List<EmployeeData> employeePayrollList){
        this.employeePayrollList=employeePayrollList;
    }

    public static void main(String[] args) throws IOException {
        
        ArrayList<EmployeeData> employeePayrollList = new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        EmployeePayrollMain employeePayrollMain = new EmployeePayrollMain(employeePayrollList);
        employeePayrollList.add(employeePayrollMain.readEmployeeData(sc));
        employeePayrollMain.writeEmployeeData();


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
    public void printData() throws IOException {
        System.out.println("\nWriting Employee Roaster to Console\n" + employeePayrollList);
    }

    public void writeEmployeeData() throws IOException {
        File file = new File("F:\\Directory\\Capgemini\\employeepayroll\\EmployeePayroll.txt");
        FileWriter myFileWriter = new FileWriter(file);
        for(int i = 0; i < employeePayrollList.size(); i++){
            myFileWriter.write(String.valueOf(employeePayrollList.get(i))+"\n");
        }
        myFileWriter.close();
    }

    public long countEntries() throws FileNotFoundException {
        File file = new File("F:\\Directory\\Capgemini\\employeepayroll\\EmployeePayroll.txt");
        long entries = 0;
        Scanner fileReader= new Scanner(file);
        while(fileReader.hasNextLine()){
            fileReader.nextLine();
            entries++;
        }
        return entries;
    }
}
