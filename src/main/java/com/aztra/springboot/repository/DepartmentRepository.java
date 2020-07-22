/**
 * 
 */
package com.aztra.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aztra.springboot.model.Department;

/**
 * @author 38609
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
