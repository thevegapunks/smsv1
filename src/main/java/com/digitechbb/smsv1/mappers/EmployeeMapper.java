package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.EmployeeDto;
import com.digitechbb.smsv1.model.entities.Employee;

public interface EmployeeMapper {
    Employee toEmployee(EmployeeDto employeeDto);
    EmployeeDto toDto(Employee employee);
}
