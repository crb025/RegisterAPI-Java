package edu.uark.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.employees.EmployeeByLookupCodeQuery;
import edu.uark.models.api.Employee;

@RestController
@RequestMapping(value = "/api/employee")

public class EmployeeRestController {
	
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable UUID employeeId) {
		return (new EmployeeByLookupCodeQuery()).
				setEmployeeId(employeeId).
				execute();
	}
	
	
}
