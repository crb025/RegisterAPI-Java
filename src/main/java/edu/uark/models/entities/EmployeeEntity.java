package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;

public class EmployeeEntity extends BaseEntity<EmployeeEntity>{
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.firstname = rs.getString(EmployeeFieldNames.FIRSTNAME);
		this.lastname = rs.getString(EmployeeFieldNames.LASTNAME);
		this.active = rs.getBoolean(EmployeeFieldNames.ACTIVE);
		this.classification = rs.getInt(EmployeeFieldNames.CLASSIFICATION);
		// this.manager_id = rs.getUUID(EmployeeFieldNames.MANAGER_ID) <- TODO: get UUID from table in a way similar to this
		this.password = rs.getString(EmployeeFieldNames.PASSWORD);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(EmployeeFieldNames.FIRSTNAME, this.firstname);
		record.put(EmployeeFieldNames.LASTNAME, this.lastname);
		record.put(EmployeeFieldNames.ACTIVE, this.active);
		record.put(EmployeeFieldNames.CLASSIFICATION, this.classification);
		record.put(EmployeeFieldNames.MANAGER_ID, this.manager_id);
		record.put(EmployeeFieldNames.PASSWORD, this.password);
		
		
		return record;
	}

	private String firstname;
	public String getFirstName() {
		return this.firstname;
	}
	public EmployeeEntity setFirstName(String firstname) {
		if (!StringUtils.equals(this.firstname, firstname)) {
			this.firstname = firstname;
			this.propertyChanged(EmployeeFieldNames.FIRSTNAME);
		}
		
		return this;
	}
	
	private String lastname;
	public String getLastName() {
		return this.lastname;
	}
	public EmployeeEntity setLastName(String lastname) {
		if (!StringUtils.equals(this.lastname, lastname)) {
			this.lastname = lastname;
			this.propertyChanged(EmployeeFieldNames.LASTNAME);
		}
		
		return this;
	}

	private boolean active;
	public boolean getActive() {
		return this.active;
	}
	public EmployeeEntity setActive(boolean active) {
		if(this.active != active) {
			this.active = active;
			this.propertyChanged(EmployeeFieldNames.ACTIVE);
		}
		
		return this;
	}
	
	private int classification;
	public int getClassification() {
		return this.classification;
	}
	public EmployeeEntity setClassification(int classification) {
		if (this.classification != classification) {
			this.classification = classification;
			this.propertyChanged(EmployeeFieldNames.CLASSIFICATION);
		}
		
		return this;
	}
	
	private UUID manager_id;
	public UUID getManagerId() {
		return this.manager_id;
	}
	public EmployeeEntity setManagerId(UUID manager_id)
	{
		if(!this.manager_id.equals(manager_id)) {
			this.manager_id = manager_id;
			this.propertyChanged(EmployeeFieldNames.MANAGER_ID);
		}
		
		return this;
	}
	
	private String password;
	public String getPassword() { 
		return this.password;
	}
	public EmployeeEntity setPassword(String password) {
		if(!this.password.equals(password)) {
			this.password = password;
			this.propertyChanged(EmployeeFieldNames.PASSWORD);
		}
		
		return this;
	}
	
	
	
	public Employee synchronize(Employee apiEmployee) {
		this.setFirstName(apiEmployee.getFirstName());
		this.setLastName(apiEmployee.getLastName());
		this.setActive(apiEmployee.getActive());
		this.setClassification(apiEmployee.getClassification());
		this.setManagerId(apiEmployee.getManagerId());
		this.setPassword(apiEmployee.getPassword());
		
		apiEmployee.setId(this.getId());
		apiEmployee.setCreatedOn(this.getCreatedOn());
		
		return apiEmployee;
	}
	
	public EmployeeEntity() {
		super(DatabaseTable.EMPLOYEE);
		
		this.firstname = StringUtils.EMPTY;
		this.lastname = StringUtils.EMPTY;
		this.active = false;
		this.classification = -1;
		this.manager_id = new UUID(0, 0);
		this.password = StringUtils.EMPTY;	
	}
	
	public EmployeeEntity(Employee apiEmployee) {
		super(DatabaseTable.EMPLOYEE);
		
		this.firstname = apiEmployee.getFirstName();
		this.lastname = apiEmployee.getLastName();
		this.active = apiEmployee.getActive();
		this.classification = apiEmployee.getClassification();
		this.manager_id = apiEmployee.getManagerId();
		this.password = apiEmployee.getPassword();	
	}
	
	
}
