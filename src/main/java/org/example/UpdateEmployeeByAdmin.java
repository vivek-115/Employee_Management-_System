package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateEmployeeByAdmin {
     Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_practice","root","root");;
    Scanner scanner;
    Statement st= con.createStatement();
    UpdateEmployeeByAdmin(Connection connection, Scanner scanner) throws SQLException {
        this.con=connection;
        this.scanner=scanner;
    }


    //Update using ID
    public void UpdateById() throws SQLException {
        System.out.println("Enter the Employee ID to update");
        int empId= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new Name");
        String EmpName=scanner.nextLine();
        System.out.println("Enter the new Mobile No ");
        String mobNo=scanner.next();
        System.out.println("Enter the new Salary");
        long empSalary=scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter the Employee Designation");
        String designation=scanner.nextLine();
        System.out.println("Enter the Employee Email ID");
        String emailID=scanner.next();
        System.out.println("Enter the username");
        String username=scanner.next();
        System.out.println("Enter the password");
        String password=scanner.next();

        String byIdQuery="update employeeTes set empName='"+EmpName+"', empMob='"+mobNo+"', empSalary="+empSalary+", empDesignation='"+designation+"',empEmail='"+emailID+"',username='"+username+"',password='"+password+"' where empId="+empId;
       int rows= st.executeUpdate(byIdQuery);
       if(rows>0){
           System.out.println("RECORD UPDATED SUCCESSFULLY");
       }
       else {
           System.out.println("RECORD NOT FOUND");
       }

    }

    //Updating the data using the name
    public void updateByName() throws SQLException {
        scanner.nextLine();
        System.out.println("Enter the new Name");
        String EmpName=scanner.nextLine();

        System.out.println("Enter the Employee ID to update");
        int empId= scanner.nextInt();
        System.out.println("Enter the new Mobile No ");
        String mobNo=scanner.next();
        System.out.println("Enter the new Salary");
        long empSalary=scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter the Employee Designation");
        String designation=scanner.nextLine();

        boolean EmailOp=true;
        String emailID=null;
        while(EmailOp){
            System.out.println("Enter the Your Email ID to update");
            emailID=scanner.next();
            String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
            if (emailID.matches(regex)) {
                EmailOp=false;
            } else {
                System.out.println("Invalid Email Address. Please enter a valid email.");
                EmailOp=true;
            }
        }

        System.out.println("Enter the username");
        String username=scanner.next();
        System.out.println("Enter the password");
        String password=scanner.next();

        String Query="update employeeTes set empId="+empId+", empMob='"+mobNo+"', empSalary="+empSalary+", empDesignation='"+designation+"',empEmail='"+emailID+"',username='"+username+"',password='"+password+"' where empName='"+EmpName+"'";
       // System.out.println(Query);
       int row= st.executeUpdate(Query);
        if(row>0){
            System.out.println("RECORD UPDATED SUCCESSFULLY");
        }
        else {
            System.out.println("RECORD NOT FOUND");
        }


    }


}
