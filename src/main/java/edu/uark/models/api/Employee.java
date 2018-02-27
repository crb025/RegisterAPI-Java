package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import edu.uark.models.entities.EmployeeEntity;

public class Employee {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Employee setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private String firstname;
	public String getFirstName() {
		return this.firstname;
	}
	public Employee setFirstName(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	private String lastname;
	public String getLastName() {
		return this.lastname;
	}
	public Employee setLastName(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Employee setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	private boolean active;
	public boolean getActive() {
		return this.active;
	}
	public Employee setActice(boolean active)
	{
		this.active = active;
		return this;
	}
	
	private int classification;
	public int getClassification() {
		return this.classification;
	}
	public Employee setClassification(int classification) {
		this.classification = classification;
		return this;
	}
	
	private UUID manager_id;
	public UUID getManagerId() {
		return this.manager_id;
	}
	public Employee setManagerId(UUID manager_id) {
		this.manager_id = manager_id;
		return this;
	}
	
	private String password;
	public String getPassword() {
		return this.password;
	}
	public Employee setPassword(String password) {
		this.password = password;
		return this;
	}
	
	
	
	public Employee() {
		this.id = new UUID(0, 0);
		this.firstname = "";
		this.lastname = "";
		this.createdOn = LocalDateTime.now();
		this.active = false;
		this.classification = -1;
		this.manager_id = new UUID(0,0);
		this.password = "";
	}
	
	public Employee(EmployeeEntity employeeEntity) {
		this.id = employeeEntity.getId();
		this.firstname = employeeEntity.getFirstName();
		this.lastname = employeeEntity.getLastName();
		this.createdOn = employeeEntity.getCreatedOn();
		this.active = employeeEntity.getActive();
		this.classification = employeeEntity.getClassification();
		this.manager_id = employeeEntity.getManagerId();
		this.password = employeeEntity.getPassword();
	}
}
