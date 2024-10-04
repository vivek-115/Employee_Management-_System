package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ChangePassword {
    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_practice","root","root");;
    Scanner scanner=new Scanner(System.in);
    Statement st= con.createStatement();
    String username;
    String pwd;

    public ChangePassword(String username, String pwd) throws SQLException {
        this.username = username;
        this.pwd = pwd;
    }
    public void changepassword() throws SQLException {
        System.out.println("Welcome");
        System.out.println("Enter the Current password");
        String password=scanner.next();

        if(password.equals(pwd)){
            System.out.println("Enter new password");
            String newPassword1= scanner.next();

            System.out.println("Again Enter the new password to Confirm!!");
            String newPassword2= scanner.next();
            if(newPassword1.equals(newPassword2)){
                String query="update employeeTes set password='"+newPassword2+"' where username='"+username+"'";
                int rows=st.executeUpdate(query);
                if(rows>0){
                  System.out.println("New PassWord Updated");
                  System.out.println("Your new Password is: "+newPassword2+" for the Username: "+username);
                }else{
                    System.out.println("Updation Failed");
                }
            }

              else {
                System.out.println("Password Updation Failed !!");
                  System.out.println("Please try again");
              }

        }
        else{
            System.out.println("Incorrect password");
        }
    }
}
