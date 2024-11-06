package com.jdbc.client;

//import java.sql.Statement;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.dao.EmployeeDaoImpl;
import com.jdbc.entity.Employee;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;


public class Main {

	public static void main(String[] args) {
		Employee emp = new Employee("Saurabh singh", "male", 10, 45787);
		EmployeeDao dao = new EmployeeDaoImpl();
		
//	     dao.insertEmp(emp);
//		 emp = new Employee("Gaurav singh","male",11,45755);
//	     dao.insertEmp(emp);
//			emp = new Employee("Dhairya singh", "male", 13, 45787);
//			dao.insertEmp(emp);
			
//			emp = new Employee("Riya Tripathi","female",14,700000);
//			dao.insertEmp(emp);
//			
//	        emp = new Employee("Tabassum Nisha","female",15,78000);
//	        dao.insertEmp(emp);
	       // dao.updateEmp(emp);
//	        dao.deleteEmp(12);
//	        dao.getEmpById(10);
	        dao.getAllEmps();
          
		
//     try {
//    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/riya1","root","Mysql@2024");
//    	Statement stmt = conn.createStatement();
//    	stmt.executeUpdate("insert into employee(id,name,gender,salary)values(8,'Divya','female',54322)");
//    	System.out.println("Transaction successfull");
//      }catch(SQLException e){
//    	  e.printStackTrace();
//      }
	}

}
