package com.talentai.us.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends  BaseEntity{
    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    @Column(name = "employee_type", columnDefinition = "ENUM('DEVELOPER_1', 'DEVELOPER_2', 'DEVELOPER_3', 'LEAD_DEVELOPER', 'MANAGER')")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private String contactNumber;
    private String email;

}
