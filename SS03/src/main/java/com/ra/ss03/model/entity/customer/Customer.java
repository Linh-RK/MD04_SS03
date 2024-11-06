package com.ra.ss03.model.entity.customer;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    @Column(name = "email", length = 100,unique = true,nullable = false)
    private String email;
    @Column(name = "full_name", length = 100,nullable = false)
    private String fullName;
    @Column(name = "password", length = 100,nullable = false)
    private String password;
    @Column(name = "birthday", length = 100,nullable = false)
    private LocalDate birthday;
    @Column(name = "status",nullable = false)
    private Boolean status;

}
