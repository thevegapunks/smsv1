package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.dtos.EmployeeDto;
import com.digitechbb.smsv1.services.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employeeDtoList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable Long id){
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping("/findByCin/{cin}")
    public ResponseEntity<EmployeeDto> findEmployeeByCin(@PathVariable String cin){
        EmployeeDto employeeDto = employeeService.findEmployeeByCin(cin);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
         boolean isDeleted = employeeService.deleteEmployeeById(id);
         if (isDeleted)
             return ResponseEntity.noContent().build();
         else
             return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.updateEmployee(employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }

}
