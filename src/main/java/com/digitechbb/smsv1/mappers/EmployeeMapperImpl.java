package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.EmployeeDto;
import com.digitechbb.smsv1.model.entities.Account;
import com.digitechbb.smsv1.model.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper{

    @Override
    public Employee toEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setCin(employeeDto.cin());
        employee.setFirstName(employeeDto.firstName());
        employee.setLastName(employeeDto.lastName());
        employee.setAddress(employeeDto.address());
        employee.setGender(employeeDto.gender());
        employee.setDateOfBirth(employeeDto.dateOfBirth());
        employee.setEmail(employeeDto.email());
        employee.setPhone(employeeDto.phone());
        employee.setStatut(employeeDto.statut());
        employee.setModeOfPayment(employeeDto.modeOfPayment());
        employee.setStartDate(employeeDto.startDate());
        employee.setSalary(employeeDto.salary());
        employee.setFonction(employeeDto.fonction());
        employee.setAccount(employeeDtoToAccount(employeeDto));
        return employee;
    }
    protected Account employeeDtoToAccount(EmployeeDto employeeDto){
        if (employeeDto == null) return null;
        if (employeeDto.accountId()==null) return null;
         Account account = new Account();
        account.setId(employeeDto.accountId());
        return account;
    }

    private Long employeeToAccountId(Employee employee){
        if (employee == null) return null;
        Account account = employee.getAccount();
        if (account==null) return null;
        Long accountId = account.getId();
        if (accountId==null) return null;
        return accountId;
    }

    @Override
    public EmployeeDto toDto(Employee employee) {
         Long accountId = employeeToAccountId(employee);
        return new EmployeeDto(
                employee.getCin(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getAddress(),
                employee.getGender(),
                employee.getDateOfBirth(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getStatut(),
                employee.getModeOfPayment(),
                employee.getStartDate(),
                employee.getSalary(),
                employee.getFonction(),
                accountId
        );
    }
}
