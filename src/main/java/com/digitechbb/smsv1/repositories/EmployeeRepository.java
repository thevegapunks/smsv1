package com.digitechbb.smsv1.repositories;

import com.digitechbb.smsv1.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
