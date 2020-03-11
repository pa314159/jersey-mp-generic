package ascelion.employee.server;

import ascelion.employee.api.Employee;
import ascelion.employee.api.EmployeeResource;
import ascelion.rest.api.ViewResourceBase;

import java.util.UUID;

public class EmployeeEndpoint extends ViewResourceBase<Employee> implements EmployeeResource {

	public EmployeeEndpoint() {
		super(Employee.class);
	}

	@Override
	public Employee getExplicit(UUID id) {
		return findById(id);
	}

	@Override
	protected Employee findById(UUID id) {
		return Employee.builder()
				.id(id)
				.firstName("firstname")
				.lastName("lastname")
				.build();
	}
}
