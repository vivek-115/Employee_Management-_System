package org.example;

import java.sql.*;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args ) throws SQLException {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_practice","root","root");
        Statement st= con.createStatement();

        Scanner scanner=new Scanner(System.in);

        CreateEmployee obj=new CreateEmployee(con,scanner);
        ReadEmployee obj1=new ReadEmployee(con,scanner);
        UpdateEmployeeByAdmin obj3=new UpdateEmployeeByAdmin(con,scanner);
        DeleteEmployee obj4=new DeleteEmployee(con,scanner);



            System.out.println("Enter the username");
        String uname=scanner.next();
            System.out.println("Enter the password");
        String pwd=scanner.next();




        String username=null;
        String password=null;
        String Eusername=null;
        String Epassword=null;

      //ADMIN LOGIN QUERY
        String query = "SELECT * FROM adminTest WHERE BINARY password = '" + uname + "' AND BINARY username = '" + pwd + "'";
        ResultSet re=st.executeQuery(query);


        while (re.next()){
            username= re.getString("username");
            password=re.getString("password");
        }

        //EMPLOYEE LOGIN QUERY
        String query1="select * from employeeTes where BINARY username= '" +uname+ "' and BINARY password= '" +pwd+ "' ";
        ResultSet rs=st.executeQuery(query1);
        while (rs.next()){
            Eusername=rs.getString("username");
            Epassword=rs.getString("password");
        }


        //VALIDATION FOR ADMIN LOGIN
            if (username != null && password != null) {

                System.out.println("Admin Login Sucessfull");
              //  int choice=0;
                //After validation showing admin Rights Menu
                boolean flag=true;
                while(flag) {
                    System.out.println("Press 1 -> insert an EMPLOYEE");
                    System.out.println("Press 2 -> Retrive an Employee");
                    System.out.println("Press 3 - Update an Employee");
                    System.out.println("Press 4 -> Delete an Employee");
                    System.out.println("Press 5 -> EXIT");
                    int choice = scanner.nextInt();


                    //ADDING RECORD TO THE TABLE
                    if (choice == 1) {
                        obj.EmployeeCreate();
                    }

                    //RETERIVING EMPLOYEE RECORDS
                    else if (choice == 2) {
                        int select = 0;
                        System.out.println("Press 1 -> To Read all employee Record");
                        System.out.println("Press 2 -> To Read an employee Record using his employee ID");
                        System.out.println("Press 3 -> To Get an employee record using his employee Name");
                        select = scanner.nextInt();
                        if (select == 1) {
                            obj1.EmployeeRead();
                        } else if (select == 2) {
                            obj1.ReadEmployeeByID();
                        } else if (select == 3) {
                            obj1.ReadEmployeeByName();
                        } else {
                            System.out.println("InValid Choice");
                        }


                    } else if (choice == 3) {
                        int select = 0;

                        System.out.println("Press 1 -> To update an employee using his employee ID");
                        System.out.println("Press 2 -> To update an employee using his Employee name");


                        select = scanner.nextInt();

                        if (select == 1) {

                            obj3.UpdateById();

                        } else if (select == 2) {

                            obj3.updateByName();

                        } else {

                            System.out.println("invalid choice");

                        }

                    } else if (choice == 4) {
                        obj4.DeleteEmployeeId();
                    } else if (choice == 5) {
                        System.out.print("Exiting");
                        for (int i = 1; i <= 3; i++) {
                            try {
                                Thread.sleep(1000);
                                System.out.print("..");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println(" ");
                        System.out.println("THANK YOU !! ");
                        break;

                    } else {
                        System.out.println("invalid Choice");
                    }
                }
            }
            //VALIDATION FOR EMPLOYEE LOGIN
            else if (Eusername != null && Epassword != null) {

                System.out.println("Employee Login Successfull");
                System.out.println(" ");
                System.out.println("Welcome " + Eusername);

                String ID = Eusername;
                String PWD = Epassword;
                boolean flag = true;
                while (flag) {


                    System.out.println("Press 1 -> TO See all Employee Records");
                    System.out.println("Press 2 -> To Search an Employee");
                    System.out.println("Press 3 -> To Update Your Details");
                    System.out.println("Press 4 -> Change Password");
                    System.out.println("Press 5 -> EXIT");

                    int choice = scanner.nextInt();
                    if (choice == 1) {

                        obj1.EmployeeRecordsForEmployee();  //to get all employee records
                    } else if (choice == 2) {
                        obj1.ReadEmployeeByNameForEmployee();   //To Search an Employee
                    } else if (choice == 3) {
                        //can't change the salary, empID, Designation,Username
                        //can only change Full name, Mobile No, Email ID
                        UpdateEmployeeByUser obj5 = new UpdateEmployeeByUser(ID, PWD);
                        obj5.UpdateEmployeeDetails();

                    } else if (choice == 4) {   //To Change Password
                        ChangePassword chgpwd = new ChangePassword(ID, PWD);
                        chgpwd.changepassword();
                    } else if (choice == 5) {

                        System.out.print("Exiting");
                        for (int i = 1; i <= 3; i++) {
                            try {
                                Thread.sleep(1000);
                                System.out.print(" . ");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println(" ");
                        System.out.println("Exited !!");
                        break;

                    } else {
                        System.out.println("Invalid Choice");
                        System.out.println("please select on of the options from the Menu");
                    }

                }

            }
            else{
                System.out.println("Login failed");
                System.out.println("please try with correct Username and Password");

            }
        }


}
