package com.talentai.us.controller;

import com.talentai.us.dto.EmployeeDto;
import com.talentai.us.dto.ResponseDto;
import com.talentai.us.entity.Employee;
import com.talentai.us.exceptions.ResourceNotFoundException;
import com.talentai.us.service.AddressService;
import com.talentai.us.service.EmployeeService;
import com.talentai.us.utility.EmployeeConstants;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/talent/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class EmployeeController {
    private EmployeeService employeeService;
    private AddressService addressService;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        if (employees == null || employees.isEmpty()) {
          throw new ResourceNotFoundException();
        }
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @PostMapping("/employees/create")
    public ResponseEntity<ResponseDto> createEmployee(@Valid @RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(EmployeeConstants.STATUS_201, EmployeeConstants.MESSAGE_201));
    }
}
