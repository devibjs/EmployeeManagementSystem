/**
 * 
 */
package com.aztra.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aztra.springboot.model.Employee;

/**
 * @author 38609
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	Employee[] findByDepartment(String department);
}
