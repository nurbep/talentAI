package com.talentai.us.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Address {
    @Id
    private Long addressId;
    private String addressLine1;
    private String addressLine2;
    private String aptNo;
    private String city;
    private String state;
    private String zipcode;

}
