package edu.uark.commands.employees;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeCreateCommand implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {

		EmployeeEntity employeeEntity = new EmployeeEntity(apiEmployee); //Create a new ENTITY object from the API object details.
		employeeEntity.save(); //Write, via an INSERT, the new record to the database.
		
		this.apiEmployee.setId(employeeEntity.getId()); //Synchronize information generated by the database upon INSERT.
		this.apiEmployee.setCreatedOn(employeeEntity.getCreatedOn());

		return this.apiEmployee;
	}

	//Properties
	private Employee apiEmployee;
	public Employee getApiEmployee() {
		return this.apiEmployee;
	}
	public EmployeeCreateCommand setApiEmployee(Employee apiEmployee) {
		this.apiEmployee = apiEmployee;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeCreateCommand setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeCreateCommand() {
		this.employeeRepository = new EmployeeRepository();
	}
}
