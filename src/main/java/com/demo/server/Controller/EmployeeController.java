package com.demo.server.Controller;

import com.demo.server.Entity.Employee;
import com.demo.server.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") int id){
		return employeeService.getEmployeeById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteEmployeeById(@PathVariable("id") int id){
		employeeService.removeEmployeeById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateEmployee(@RequestBody Employee employee){
		employeeService.updateEmployee(employee);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertEmployee(@RequestBody Employee employee){
		employeeService.insertEmployee(employee);
	}
}
