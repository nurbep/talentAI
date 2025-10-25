package com.talentai.us.service;

import com.talentai.us.dto.EmployeeDto;
import com.talentai.us.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();
    void createEmployee(Employee employee);
}
