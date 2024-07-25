package com.example.javaframeworkassessement1.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {
    private Long id;
    private String roleName;
    private String description;
}
