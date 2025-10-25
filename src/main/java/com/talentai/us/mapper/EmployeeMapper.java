package com.talentai.us.mapper;

import com.talentai.us.dto.EmployeeDto;
import com.talentai.us.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDto mapToEmployeeDto(Employee employee, EmployeeDto employeeDto) {
      employeeDto.setEmployeeId(employee.getEmployeeId());
      employeeDto.setFirstName(employee.getFirstName());
      employeeDto.setLastName(employee.getLastName());
      employeeDto.setContactNumber(employee.getContactNumber());
      employeeDto.setEmail(employee.getEmail());
      employeeDto.setEmployeeType(employee.getEmployeeType());
      employeeDto.setAddress(employee.getAddress());

      return employeeDto;
    }
}
