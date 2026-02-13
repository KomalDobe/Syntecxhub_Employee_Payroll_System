package com.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteEmployee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Employee ID to delete: ");
            int id = sc.nextInt();

            String query = "DELETE FROM employees WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Employee Deleted Successfully!");
            else
                System.out.println("Employee ID not found!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
