package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.dtos.EmployeeDto;
import com.digitechbb.smsv1.model.entities.Employee;

public interface EmployeeService {
    EmployeeDto saveEmployee(Employee employee);
}
