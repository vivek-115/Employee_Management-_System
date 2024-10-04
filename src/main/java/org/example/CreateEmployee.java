package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateEmployee {
    private Scanner scanner;
    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_practice","root","root");
    Statement st= con.createStatement();
    CreateEmployee(Connection connection, Scanner scanner) throws SQLException {
        this.con=connection;
        this.scanner=scanner;
    }


    public void EmployeeCreate() throws SQLException {

        boolean calOp=true;
        while(calOp){
            System.out.println("Enter the username");
            String username=scanner.next();
            System.out.println("Enter the password");
            String password=scanner.next();
            System.out.println("Enter the Employee ID");
            int empId=scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the Employee name");
            String name=scanner.nextLine();

            boolean MobOp=true;
            String empMob=null;

            while(MobOp){
                System.out.println("Enter the Mobile Number");
                empMob=scanner.next();
                String regex = "^\\d{10}$";
                if (empMob.matches(regex)) {
                    MobOp=false;
                } else {
                    System.out.println("Invalid Mobile Number. Please enter a 10-digit number.");
                    MobOp=true;
                }
            }


            System.out.println("Enter the Employee salary");
            long salary= scanner.nextLong();
            scanner.nextLine();
            System.out.println("Enter the Employee Designation");
            String designation=scanner.nextLine();

            boolean EmailOp=true;
            String emailID=null;
            while(EmailOp){
                System.out.println("Enter the Employee Email ID");
                 emailID=scanner.next();
                String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
                if (emailID.matches(regex)) {
                   EmailOp=false;
                } else {
                    System.out.println("Invalid Email Address. Please enter a valid email.");
                    EmailOp=true;
                }
            }


            String insertQuery="insert into employeeTes values('"+username+"','"+password+"',"+empId+",'"+name+"','"+empMob+"',"+salary+",'"+designation+"','"+emailID+"')";
            st.execute(insertQuery);
            System.out.println(insertQuery);
            System.out.println("Inserted sucessfully");

            System.out.println("Do you want to insert another employee[yes/no]");
            char c= scanner.next().charAt(0);
            if(c=='Y' || c=='y'){
                calOp=true;
            }
            else {
                calOp=false;

            }
        }



    }

}
