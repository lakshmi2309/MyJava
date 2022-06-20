package com.example.EmployeeNewJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class EmployeeNewJDBCApplication implements CommandLineRunner {

	@Autowired
	DepartmentRepository deptRep;

	public static void main(String[] args) { SpringApplication.run(EmployeeNewJDBCApplication.class, args);}

	public void run(String... args)throws Exception{
		List<Department> depts = deptRep.findAllDepartments();
		for (Department d: depts){
			System.out.println(d);
		}

	}
}

