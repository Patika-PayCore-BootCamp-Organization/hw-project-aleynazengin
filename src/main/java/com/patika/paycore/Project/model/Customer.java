package com.patika.paycore.Project.model;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Firstname can not be null")
    private String firstname;

    @NotNull(message = "Lastname can not be null")
    private String lastname;

    @NotNull(message = "Gender can not be null")
    private String gender;

    @NotNull(message = "Age can not be null")
    private Integer age;

    @NotNull(message = "Phone can not be null")
    private String phone;

    @Email
    private String email;
}
