package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.jdbc.entity.Employee;
import com.mysql.cj.jdbc.Driver;

public class EmployeeDaoImpl implements EmployeeDao{
   static Connection conn;
   static {
	   try {
		   Properties prop = new Properties();
		   prop.put("user", "root");
		   prop.put("password", "Mysql@2024");
		   // 1st way to use jdbc is in a simple way write user and password
//		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/riya1","root","Mysql@2024");
		   // 2nd way is with the help of properties use drivermanager
//		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/riya1",prop);
		   Driver d = new Driver();
		   conn = d.connect("jdbc:mysql://localhost:3306/riya1",prop);
		   
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
   }
	public void insertEmp1(Employee e) {
       try {
    	   Statement stmt = conn.createStatement();
    	   stmt.executeUpdate("insert into employee(id,name,gender,salary) values("+e.getId()+"," + e.getName()+"," + e.getGender()+","+e.getSalary() +")");
    	   System.out.println("EmployeeDaoImpl.insertEmp()");
       }catch(SQLException e1) {
    	   e1.printStackTrace();
       }
	}

	public void getEmpById(int id) {
		try(Statement statement = conn.createStatement()){
				ResultSet rs = statement.executeQuery("select * from employee where id = " + id);
				while(rs.next()) {
					System.out.println("ID " + rs.getInt("id") + " , Gender = " + rs.getString("name") + " , Salary = " + rs.getInt("salary"));
				}
			}catch(SQLException e1){
			e1.printStackTrace();
		}
	}

	public void getAllEmps() {
     		try(Statement statement = conn.createStatement()){
     			ResultSet rs = statement.executeQuery("select * from employee");
     			while(rs.next()){
     				System.out.println("ID =" + rs.getInt(1) + " Name = " +rs.getString(2) + " Gender = " + rs.getString(3) +" Salary = " +rs.getInt(4));
     			}
     		}catch(SQLException e) {
     			e.printStackTrace();
     		}
	}

	public void insertEmp(Employee e) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into employee(id,name,gender,salary) values(" +e.getId()+",'"+e.getName()+"' , '"+e.getGender()+"',"+e.getSalary()+")");
			System.out.println("EmployeeDaoImpl.insertEmp()");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
	}

	public void updateEmp(Employee e) {
		try (Statement statement = conn.createStatement()) {
			statement.executeUpdate("update employee set name = '" + e.getName() + "' , salary = " + e.getSalary()
					+ " where id = " + e.getId());
			System.out.println("Update successful..................");

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void deleteEmp(int id) {
      	try(Statement statement = conn.createStatement()){
      		statement.executeUpdate("delete from employee where id = " + id);
      		System.out.println("Record deleted successfully.....");
      	}catch(SQLException e){
      		e.printStackTrace();
      	}
	}
}
