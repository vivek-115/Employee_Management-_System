package org.example;

import java.sql.*;
import java.util.Scanner;

public class UpdateEmployeeByUser {
    String username;
    String password;
    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_practice","root","root");;
    Scanner scanner=new Scanner(System.in);
    Statement st= con.createStatement();

    public UpdateEmployeeByUser(String username,String password) throws SQLException {
        this.username=username;
        this.password=password;

    }
    public void UpdateEmployeeDetails() throws SQLException {
        int empID=0;
        System.out.println("Enter the Emp ID to verify");
        int ID= scanner.nextInt();
        String query="select * from employeeTes where username='"+username+"' and empId="+ID;
        ResultSet rs =st.executeQuery(query);
        while ((rs.next())){
             empID=rs.getInt("empId");
        }
        if(empID==ID){

            System.out.println("Press 1 -> To Update Name");
            System.out.println("Press 2 -> To Update Mobile Number");
            System.out.println("Press 3 -> To Update Email ID");
            int choice= scanner.nextInt();

            if(choice==1){
                scanner.nextLine();
                System.out.println("Enter the Name to update");
                String name=scanner.nextLine();
                String queryName="update employeeTes set empName='"+name+"' where username='"+username+"' and password='"+password+"' ";
                int rows=st.executeUpdate(queryName);

                if(rows>0){
                    System.out.println("Your name has been Updated as: "+name);
                }
                else{
                    System.out.println("Record Updation Failed");
                }
            }
            else if (choice==2) {
                boolean MobOp=true;
                String empMob=null;

                while(MobOp){
                    System.out.println("Enter the Mobile Number to Update");
                    empMob=scanner.next();
                    String regex = "^\\d{10}$";
                    if (empMob.matches(regex)) {
                        MobOp=false;
                    } else {
                        System.out.println("Invalid Mobile Number. Please enter a 10-digit number.");
                        MobOp=true;
                    }
                }
                String queryMob="update employeeTes set empMob='"+empMob+"' where username='"+username+"' and password='"+password+"' ";
                int rows=st.executeUpdate(queryMob);
                if(rows>0){
                    System.out.println("Your Mobile No has been updated as "+empMob);
                }
                else {
                    System.out.println("Mobile Number Updation Failed");
                }
            }
            else if (choice==3)
            {
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
                String queryMob="update employeeTes set empEmail='"+emailID+"' where username='"+username+"' and password='"+password+"' ";
                int rows=st.executeUpdate(queryMob);
                if(rows>0){
                    System.out.println("Your Email ID has been updated as "+emailID);
                }
                else {
                    System.out.println("Email-ID Updation Failed");
                }


            }
            else {
                System.out.println("Invalid Choice");
            }

        }
        else{
            System.out.println("Your Emp ID is incorrect!! Please try again");
        }

    }


}
