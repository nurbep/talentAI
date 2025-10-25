package com.talentai.us.service.impl;

import com.talentai.us.dto.EmployeeDto;
import com.talentai.us.entity.Employee;
import com.talentai.us.exceptions.EmployeeAlreadyExistsException;
import com.talentai.us.mapper.EmployeeMapper;
import com.talentai.us.repository.EmployeeRepository;
import com.talentai.us.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(e -> employeeMapper.mapToEmployeeDto(e, new EmployeeDto())).collect(Collectors.toList());

    }

    @Override
    public void createEmployee(Employee employee) {
        Optional<Employee> optionalCustomer = employeeRepository.findByContactNumber(employee.getContactNumber());
        if(optionalCustomer.isPresent()) {
            throw new EmployeeAlreadyExistsException("Employee already registered with given contact number."
                    +employee.getContactNumber());
        }
        employeeRepository.save(employee);
    }
}
