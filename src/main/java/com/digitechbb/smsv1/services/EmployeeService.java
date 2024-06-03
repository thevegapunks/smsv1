package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.dtos.EmployeeDto;
import com.digitechbb.smsv1.model.entities.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto findEmployeeByCin(String cin);
}
