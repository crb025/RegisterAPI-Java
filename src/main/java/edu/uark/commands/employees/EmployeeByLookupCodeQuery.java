package edu.uark.commands.employees;

import java.util.UUID;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeByLookupCodeQuery implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		if (this.employeeId == null) {
			throw new UnprocessableEntityException("employeeId");
		}
		
		EmployeeEntity employeeEntity = this.employeeRepository.byEmployeeId(this.employeeId);
		if (employeeEntity != null) {
			return new Employee(employeeEntity);
		} else {
			throw new NotFoundException("Employee");
		}
	}
	
	//Properties
	private UUID employeeId;
	public UUID getLookupCode() {
		return this.employeeId;
	}
	public EmployeeByLookupCodeQuery setEmployeeId(UUID employeeId) {
		this.employeeId = employeeId;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeByLookupCodeQuery setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeByLookupCodeQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
	
}
