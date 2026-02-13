package com.emp;

import java.sql.*;
	import java.util.Scanner;

	public class PayrollSystem {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        try {

	            Connection con = DBConnection.getConnection();

	            System.out.print("Enter Employee Name: ");
	            String name = sc.next();

	            System.out.print("Enter Basic Salary: ");
	            double basic = sc.nextDouble();

	            double hra = basic * 0.20;
	            double da = basic * 0.10;
	            double total = basic + hra + da;

	            String query = "INSERT INTO employees(name,basic_salary,hra,da,total_salary) VALUES(?,?,?,?,?)";

	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setString(1, name);
	            ps.setDouble(2, basic);
	            ps.setDouble(3, hra);
	            ps.setDouble(4, da);
	            ps.setDouble(5, total);

	            int rows = ps.executeUpdate();

	            if (rows > 0) {
	                System.out.println("Employee Added Successfully!");
	            } else {
	                System.out.println("Insert Failed!");
	            }


	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	}


