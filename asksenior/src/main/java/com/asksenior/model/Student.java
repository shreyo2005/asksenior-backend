package com.asksenior.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String fullName;
    private String phone;

    private String college;       // target / current college
    private String course;
    private String customCourse;
    private String year;
    private String city;
    private String linkedInUrl;

    private LocalDateTime registeredAt;
}

