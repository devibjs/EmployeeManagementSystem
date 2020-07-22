/**
 * 
 */
package com.aztra.springboot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author 38609
 *
 */

@Entity
@Table(name = "Department")
public class Department {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String deptName;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Employee> employees;

	/**
	 * 
	 */
	public Department() {
	}

	/**
	 * @param department_ID
	 * @param department_Name
	 */
	public Department(Long id, String department_Name) {
		super();
		this.id = id;
		this.deptName = department_Name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName
	 *            the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees
	 *            the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * @param employee
	 */
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	/**
	 * @param employee
	 */
	public void removeEmployee(Employee employee) {
		employees.remove(employee);

	}

}
