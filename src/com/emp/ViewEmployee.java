package com.emp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewEmployee {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM employees";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            System.out.println("ID | Name | Basic Salary | Total Salary");
            System.out.println("----------------------------------------");

            while(rs.next()) {

                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getDouble("basic_salary") + " | " +
                    rs.getDouble("total_salary")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

