package com.example.javaframeworkassessement1.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Company {
    private Long id;
    private String companyCode;
    private String companyName;
    private String domain;
    private String country;
    private String phone;
}
