package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteEmployee {
    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_practice","root","root");;
    Scanner scanner;
    Statement st= con.createStatement();
    DeleteEmployee(Connection connection,Scanner scanner) throws SQLException {
        this.con=connection;
        this.scanner=scanner;
    }

    public void DeleteEmployeeId() throws SQLException {
        boolean calOp=true;
        while (calOp) {


            System.out.println("Enter the Employee ID to DELETE the Employee Record");
            int id = scanner.nextInt();
            String query = "delete from employeeTes where empId=" + id;

            int rows = st.executeUpdate(query);
            if (rows > 0) {
                System.out.println("Employee with Employee ID: " + id + " Deleted Sucessfully");
            } else {
                System.out.println("No Such Record found");
                System.out.println("Please enter the correct Employee ID");
            }
            System.out.println("Do you want to DELETE another employee[yes/no]");
            char c = scanner.next().charAt(0);
            if (c == 'Y' || c == 'y') {
                calOp = true;
            } else {
                calOp = false;

            }
        }

    }

}
