package com.asksenior.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "insiders")
public class Insider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String collegeName;
    private String year;
    private String course;

    private String fullName;
    private String phone;

    @Column(length = 500)
    private String bio;

    private String photoUrl;

    private String upiId;
    private String collegeIdNumber;

    @Column(length = 1000)
    private String adminSummary;

    private LocalDateTime registeredAt;
}