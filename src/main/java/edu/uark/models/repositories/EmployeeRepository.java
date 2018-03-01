package edu.uark.models.repositories;

import java.util.UUID;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.dataaccess.repository.helpers.PostgreFunctionType;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeRepository extends BaseRepository<EmployeeEntity> implements EmployeeRepositoryInterface {
	
	@Override
	public EmployeeEntity byEmployeeId(UUID employeeId)
	{
		return this.firstOrDefaultWhere(
				new WhereContainer(
					(new WhereClause()).
					 	postgreFunction(PostgreFunctionType.LOWER).
						table(this.primaryTable).
						fieldName(EmployeeFieldNames.ID).
						comparison(SQLComparisonType.EQUALS)
				),
				(ps) -> {

					return ps;
				}
			);
	}
	
	@Override
	public EmployeeEntity createOne() {
		return new EmployeeEntity();
	}
	
	public EmployeeRepository() {
		super(DatabaseTable.EMPLOYEE);
	}
}
