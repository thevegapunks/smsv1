package com.digitechbb.smsv1.repositories;

import com.digitechbb.smsv1.model.dtos.EmployeeDto;
import com.digitechbb.smsv1.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findEmployeeByCin(String cin);
    @Query("SELECT e.id FROM Employee e WHERE e.cin = :cin")
    Long findIdByCin(@Param("cin") String cin);
}
