package com.talentai.us.dto;

import com.talentai.us.entity.Address;
import com.talentai.us.entity.EmployeeType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeDto {
    @NotEmpty(message = "Employee Id can not be a null or empty")
    private String employeeId;
    @NotEmpty(message = "First Name can not be a null or empty")
    @Size(min = 2, max = 30, message = "The length of the Employee first name should be between 2 and 30")
    private String firstName;
    private String lastName;
    @Column(name = "employee_type", columnDefinition = "ENUM('DEVELOPER_1', 'DEVELOPER_2', 'DEVELOPER_3', 'LEAD_DEVELOPER', 'MANAGER')")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String contactNumber;
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;
}
