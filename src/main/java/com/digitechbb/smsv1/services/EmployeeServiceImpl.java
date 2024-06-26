package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.mappers.EmployeeMapper;
import com.digitechbb.smsv1.model.dtos.EmployeeDto;
import com.digitechbb.smsv1.model.entities.Employee;
import com.digitechbb.smsv1.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee=employeeMapper.toEmployee(employeeDto);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
//        Employee employee = employeeRepository.findEmployeeByCin(employeeDto.cin());
        Long id = employeeRepository.findIdByCin(employeeDto.cin()) ;
        if (id==null)
            return null;
        Employee updatedEmployee = employeeMapper.toEmployee(employeeDto);
        updatedEmployee.setId(id);

        return employeeMapper.toDto(employeeRepository.save(updatedEmployee));
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return employeeMapper.toDto(employeeRepository.findById(id).orElse(null));
    }

    @Override
    public boolean deleteEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee!=null){
            employeeRepository.deleteById(id);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        return employeeRepository.findAll().stream().map(employee -> employeeMapper.toDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto findEmployeeByCin(String cin) {
        return employeeMapper.toDto(employeeRepository.findEmployeeByCin(cin));
    }
}
