/**
 * 
 */
package com.aztra.springboot.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.aztra.springboot.exception.EmployeeNotFoundException;
import com.aztra.springboot.model.Department;
import com.aztra.springboot.model.Employee;
import com.aztra.springboot.repository.DepartmentRepository;
import com.aztra.springboot.repository.EmployeeRepository;

/**
 * @author 38609
 *
 */
@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

	protected static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class.getName());

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aztra.springboot.services.EmployeeService#create(com.aztra.springboot
	 * .model.Employee)
	 */
	@Override
	public Employee create(Employee employee) {
		logger.info("create : Start");
		try {
			Department department = departmentRepository.getOne(employee.getDepartment().getId());
			Employee em = new Employee(employee.getId(), employee.getFirstName(), employee.getLastName(),
					employee.getEmailId(), department);
			department.addEmployee(em);
			Employee emp = employeeRepository.save(em);
			logger.info("create : End");
			return emp;
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Data Exception occured while inserting record");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aztra.springboot.services.EmployeeService#update(java.lang.Long,
	 * com.aztra.springboot.model.Employee)
	 */
	@Override
	public Employee update(Long employeeId, Employee employee) throws EmployeeNotFoundException {
		logger.info("update : Start");
		Employee em = employeeRepository.getOne(employee.getId());
		if (em == null) {
			logger.error("No Such Employee available for given ID : {}", employee.getId());
			throw new EmployeeNotFoundException("No Such Employee available for given ID : " + employee.getId());
		}
		em.setEmailId(employee.getEmailId());
		em.setLastName(employee.getLastName());
		em.setFirstName(employee.getFirstName());
		if (em.getDepartment().getId() != employee.getDepartment().getId()) {
			Department department = em.getDepartment();
			department.removeEmployee(em);
			Department dep = departmentRepository.getOne(employee.getDepartment().getId());
			em.setDepartment(dep);
			dep.addEmployee(em);
		}
		Employee emp = employeeRepository.save(employee);
		logger.info("update : End");
		return emp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aztra.springboot.services.EmployeeService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long employeeId) {
		logger.info("delete : Start");
		try {
			Employee em = employeeRepository.getOne(employeeId);
			Department department = em.getDepartment();
			department.removeEmployee(em);
			employeeRepository.delete(em);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Data Exception occured while inserting record");
		}
		logger.info("delete : end");
	}

	/**
	 * @param departmentId
	 * @return
	 */
	@Override
	public List<Employee> getEmployeesOfDepartment(Long departmentId) {
		logger.info("getEmployeesOfDepartment : Start");
		try {
			Department department = departmentRepository.getOne(departmentId);
			List<Employee> employees = new ArrayList<>();
			department.getEmployees().forEach(x -> employees.add(x));
			logger.info("getEmployeesOfDepartment : end");
			return employees;
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Data Exception occured while inserting record");
		}

	}

}
