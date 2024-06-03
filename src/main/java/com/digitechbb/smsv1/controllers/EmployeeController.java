package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.dtos.EmployeeDto;
import com.digitechbb.smsv1.services.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
@CrossOrigin(origins ={"http://localhost:4200", "http://localhost"})
@AllArgsConstructor
public class EmployeeController  {

    private EmployeeService employeeService;

    @PostMapping
    public EmployeeDto save(@RequestBody EmployeeDto employeeDto){
        return employeeService.saveEmployee(employeeDto);
    }
    @GetMapping
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/findByCin/{cin}")
    public EmployeeDto findEmployeeByCin(@PathVariable String cin){
        return employeeService.findEmployeeByCin(cin);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
         employeeService.deleteEmployeeById(id);
    }

    @PutMapping
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(employeeDto);
    }

}
