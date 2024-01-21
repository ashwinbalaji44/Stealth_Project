package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "Employee")
public class Employee_Controller 
{
	@Autowired
	Employee_Service er;
	@Autowired
	Leave_Service lr;
	
	//employee can register
	@PostMapping("/SignUp")
	public String Register_Employee(@RequestBody Employee employee) {
		return er.register_employee(employee);
	}
	
	//employee can login
	@PostMapping(value = "SignIn",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String Login_Employee(@RequestBody Employee employee)
	{
		return er.login_employee(employee);
	}
	
	//employee can view his/her detail
	@GetMapping("viewdetails/{email}")
	public Optional<Employee> viewdetails(@PathVariable("email") String email)
	{
		return er.viewemployeedetail(email);
	}
	
	//employee can apply leave
	@PostMapping(value = "applyleave",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String Apply_Leave(@RequestBody Leave l)
	{
		return er.apply_leave(l);
	}
	
	@GetMapping("/viewleaves/{empid}")
	public List<Leave> viewLeaves(@PathVariable("empid") int empId)
	{
		//System.out.println(er.getAllLeavesForEmployee(empId));
		return er.getAllLeavesForEmployee(empId);
	}
	

	
	
}
