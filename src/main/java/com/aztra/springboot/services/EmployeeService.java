/**
 * 
 */
package com.aztra.springboot.services;

import java.util.List;

import com.aztra.springboot.exception.EmployeeNotFoundException;
import com.aztra.springboot.model.Employee;

/**
 * @author 38609
 *
 */
public interface EmployeeService {

	/**
	 * @param employee
	 * @return
	 */
	Employee create(Employee employee);

	/**
	 * @param employeeId
	 * @param employee
	 * @return
	 * @throws EmployeeNotFoundException 
	 */
	Employee update(Long employeeId, Employee employee) throws EmployeeNotFoundException;

	/**
	 * @param employeeId
	 */
	void delete(Long employeeId);

	/**
	 * @param departmentId
	 * @return
	 */
	List<Employee> getEmployeesOfDepartment(Long departmentId);

}
