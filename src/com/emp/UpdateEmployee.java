package com.emp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateEmployee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Employee ID to update: ");
            int id = sc.nextInt();

            System.out.print("Enter new Basic Salary: ");
            double basic = sc.nextDouble();

            double hra = basic * 0.20;
            double da = basic * 0.10;
            double total = basic + hra + da;

            String query = "UPDATE employees SET basic_salary=?, hra=?, da=?, total_salary=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, basic);
            ps.setDouble(2, hra);
            ps.setDouble(3, da);
            ps.setDouble(4, total);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Employee Updated Successfully!");
            else
                System.out.println("Employee ID not found!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
