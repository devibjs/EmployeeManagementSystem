/**
 * 
 */
package com.aztra.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aztra.springboot.exception.EmployeeNotFoundException;
import com.aztra.springboot.model.Employee;
import com.aztra.springboot.services.EmployeeService;

/**
 * @author 38609
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/employee" })
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public Employee create(@RequestBody Employee employee) {
		return employeeService.create(employee);
	}

	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@RequestBody Employee employee)
			throws InvalidConfigurationPropertyValueException, EmployeeNotFoundException {
		Employee updatedEmployee = employeeService.update(employeeId, employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws InvalidConfigurationPropertyValueException {
		employeeService.delete(employeeId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping(value = "employees/{id}")
	public ResponseEntity<List<Employee>> getDepartmentEmployees(@PathVariable long id) {
		List<Employee> employees = employeeService.getEmployeesOfDepartment(id);

		if (employees == null) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(employees);
	}
}
