package org.example;

import java.sql.*;
import java.util.Scanner;

public class ReadEmployee {

    private Scanner scanner;
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_practice", "root", "root");
    Statement st = con.createStatement();

    ReadEmployee(Connection connection, Scanner scanner) throws SQLException {
        this.con = connection;
        this.scanner = scanner;
    }

    private String uname = null;
    private String pwd = null;
    private int empId = 0;
    private String empname = null;
    private String empMobNo = null;
    private long empSalary = 0;
    private String empDesignation = null;
    private String EmpEmailID = null;


    //READING ALL EMPLOYEE NAME
    public void EmployeeRead() throws SQLException {
        String RetierveQuery = "select * from employeetes";
        ResultSet rs = st.executeQuery(RetierveQuery);

        System.out.println("                                               *********************    ALL EMPLOYEE RECORDS   **********************");
        System.out.println("+-------------+----------------------+---------------+--------------------------+-------------------+----------------+---------------------------+------------------------------------+ ");
        System.out.println("|  USERNAME   |       PASSWORD       |     EMP ID    |         FULL NAME        |     MOBILE NO     |  SALARY/MONTH  |    EMPLOYEE DESIGNATION   |           EMAIL ID                 | "  );
        System.out.println("+-------------+----------------------+---------------+--------------------------+-------------------+----------------+---------------------------+------------------------------------+ ");


        while (rs.next()) {
            uname = rs.getString("username");
            pwd = rs.getString("password");
            empId = rs.getInt("empId");
            empname = rs.getString("empName");
            empMobNo = rs.getString("empMob");
            empSalary = rs.getLong("empSalary");
            empDesignation = rs.getString("empDesignation");
            EmpEmailID = rs.getString("empEmail");

            String formattedData = String.format("%-20s %-20s %-13d %-28s %-20s %-15d %-28s %-30s",
                    uname, pwd, empId, empname, empMobNo, empSalary, empDesignation, EmpEmailID);
            System.out.println(formattedData);

        }

        System.out.println("+-------------+----------------------+---------------+--------------------------+-------------------+----------------+---------------------------+-----------------------------+ ");

    }


    //READING EMPLOYEE USING THE EMPLOYEE ID
    public void ReadEmployeeByID() throws SQLException {
        System.out.println("Enter the Emp ID to view the Record");
        int n=scanner.nextInt();
        String query="select * from employeeTes where empId="+n;
       ResultSet rs= st.executeQuery(query);
        System.out.println("                                               *********************    EMPLOYEE RECORD USING ID  **********************");
        System.out.println("+-------------+----------------------+---------------+--------------------------+-------------------+----------------+---------------------------+------------------------------------+ ");
        System.out.println("|  USERNAME   |       PASSWORD       |     EMP ID    |         FULL NAME        |     MOBILE NO     |  SALARY/MONTH  |    EMPLOYEE DESIGNATION   |           EMAIL ID                 | "  );
        System.out.println("+-------------+----------------------+---------------+--------------------------+-------------------+----------------+---------------------------+------------------------------------+ ");

        while (rs.next()) {
            uname = rs.getString("username");
            pwd = rs.getString("password");
            empId = rs.getInt("empId");
            empname = rs.getString("empName");
            empMobNo = rs.getString("empMob");
            empSalary = rs.getLong("empSalary");
            empDesignation = rs.getString("empDesignation");
            EmpEmailID = rs.getString("empEmail");
        }
            String formattedData = String.format("%-20s %-20s %-13d %-28s %-20s %-15d %-28s %-30s",
                    uname, pwd, empId, empname, empMobNo, empSalary, empDesignation, EmpEmailID);
            System.out.println(formattedData);

            System.out.println("+-------------+----------------------+---------------+--------------------------+-------------------+----------------+---------------------------+-----------------------------+ ");
//

    }

    //String query = "SELECT * FROM "TABLE_NAME" WHERE empName LIKE '" + "YOUR INPUT" + "%'";
    //READINg EMPLOYEE USING NAME
    public void ReadEmployeeByName() throws SQLException {
        scanner.nextLine();
        System.out.println("Enter the new Name");
        String EmpName=scanner.nextLine();

        String query="SELECT * FROM employeeTes WHERE empName LIKE '" + EmpName + "%'";
     ResultSet rs=st.executeQuery(query);


        System.out.println("                                               *********************    EMPLOYEE RECORD USING NAME  **********************");
        System.out.println("+-------------+----------------------+---------------+--------------------------+-------------------+----------------+---------------------------+------------------------------------+ ");
        System.out.println("|  USERNAME   |       PASSWORD       |     EMP ID    |         FULL NAME        |     MOBILE NO     |  SALARY/MONTH  |    EMPLOYEE DESIGNATION   |           EMAIL ID                 | "  );
        System.out.println("+-------------+----------------------+---------------+--------------------------+-------------------+----------------+---------------------------+------------------------------------+ ");

        while (rs.next()) {
            uname = rs.getString("username");
            pwd = rs.getString("password");
            empId = rs.getInt("empId");
            empname = rs.getString("empName");
            empMobNo = rs.getString("empMob");
            empSalary = rs.getLong("empSalary");
            empDesignation = rs.getString("empDesignation");
            EmpEmailID = rs.getString("empEmail");

            String formattedData = String.format("%-20s %-20s %-13d %-28s %-20s %-15d %-28s %-30s",
                    uname, pwd, empId, empname, empMobNo, empSalary, empDesignation, EmpEmailID);
            System.out.println(formattedData);
        }



        System.out.println("+-------------+----------------------+---------------+--------------------------+-------------------+----------------+---------------------------+-----------------------------+ ");
//
    }



    //   **************************************************************************************************************
    //   To View ALL Employee Records

    public void EmployeeRecordsForEmployee() throws SQLException {
        String RetierveQuery = "select * from employeetes";
        ResultSet rs = st.executeQuery(RetierveQuery);

        System.out.println("                                               *********************    ALL EMPLOYEE RECORDS   **********************");
        System.out.println("+-------------+-------------------------+-------------------------+--------------------------------+------------------------------------+");
        System.out.println("|  EMP ID     |        FULL NAME        |          MOBILE NO      |         EMPLOYEE DESIGNATION   |           EMAIL ID                 | "  );
        System.out.println("+-------------+-------------------------+-------------------------+--------------------------------+------------------------------------+");

        System.out.println(RetierveQuery);

        while (rs.next()) {
            empId = rs.getInt("empId");
            empname = rs.getString("empName");
            empMobNo = rs.getString("empMob");
            empDesignation = rs.getString("empDesignation");
            EmpEmailID = rs.getString("empEmail");

            String formattedData = String.format("%-20s %-28s %-28s %-28s %-28s",
                    empId, empname, empMobNo, empDesignation, EmpEmailID);
            System.out.println(formattedData);

        }
        System.out.println("+-------------+-------------------------+-------------------------+--------------------------------+------------------------------------+");


    }

    public void ReadEmployeeByNameForEmployee() throws SQLException {
        scanner.nextLine();
        System.out.println("Enter the new Name");
        String EmpName=scanner.nextLine();

        String query="SELECT * FROM employeeTes WHERE empName LIKE '" + EmpName + "%'";
        ResultSet rs=st.executeQuery(query);


        System.out.println("                                               *********************    ALL EMPLOYEE RECORDS   **********************");
        System.out.println("+-------------+-------------------------+-------------------------+--------------------------------+------------------------------------+");
        System.out.println("|  EMP ID     |        FULL NAME        |          MOBILE NO      |         EMPLOYEE DESIGNATION   |           EMAIL ID                 | "  );
        System.out.println("+-------------+-------------------------+-------------------------+--------------------------------+------------------------------------+");

        while (rs.next()) {
            empId = rs.getInt("empId");
            empname = rs.getString("empName");
            empMobNo = rs.getString("empMob");
            empDesignation = rs.getString("empDesignation");
            EmpEmailID = rs.getString("empEmail");

            String formattedData = String.format("%-20s %-28s %-28s %-28s %-28s",
                    empId, empname, empMobNo, empDesignation, EmpEmailID);
            System.out.println(formattedData);
        }



        System.out.println("+-------------+-------------------------+-------------------------+--------------------------------+------------------------------------+");

    }

}
