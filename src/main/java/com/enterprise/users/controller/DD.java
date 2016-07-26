package com.enterprise.users.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DD {
	
		public static void main(String args[]) {
			Connection c = null;
			Statement stmt = null;
			try {
				createTable();
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:mydb.db");
				c.setAutoCommit(false);
				System.out.println("Opened database successfully");

				stmt = c.createStatement();
				String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
						+ "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
				stmt.executeUpdate(sql);

				sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
						+ "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
				stmt.executeUpdate(sql);

				sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
						+ "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
				stmt.executeUpdate(sql);

				sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
						+ "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
				stmt.executeUpdate(sql);

				stmt.close();
				c.commit();
				c.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
			System.out.println("Records created successfully");
		}
		
		public static void createTable() {
			Connection c = null;
			Statement stmt = null;
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:mydb.db");
				System.out.println("Opened database successfully");

				stmt = c.createStatement();
				String sql = "CREATE TABLE COMPANY "
						+ "(ID INT PRIMARY KEY     NOT NULL,"
						+ " NAME           TEXT    NOT NULL, "
						+ " AGE            INT     NOT NULL, "
						+ " ADDRESS        CHAR(50), " + " SALARY         REAL)";
				stmt.executeUpdate(sql);
				stmt.close();
				c.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
			System.out.println("Table created successfully");
		}
	

}
