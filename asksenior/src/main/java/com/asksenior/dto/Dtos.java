package com.asksenior.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

public class Dtos {

    @Data
    public static class AuthRequest {
        @Email(message = "Please provide a valid email")
        @NotBlank(message = "Email is required")
        private String email;
    }

    @Data
    @AllArgsConstructor
    public static class AuthResponse {
        private Long id;
        private String email;
        private String role;
    }

    @Data
    public static class InsiderCollegeRequest {
        @NotBlank private String college;
        @NotBlank private String course;
        private String customCourse;
        @NotBlank private String year;
    }

    @Data
    public static class InsiderProfileRequest {
        @NotBlank private String fullName;
        @NotBlank private String phone;
        private String bio;
        private String linkedInUrl;
    }

    @Data
    public static class InsiderPayoutRequest {
        @NotBlank private String upiId;
        @NotBlank private String collegeIdNumber;
        private String adminSummary;
    }

    @Data
    public static class MentorProfileRequest {
        @NotBlank private String fullName;
        @NotBlank private String phone;
        @NotBlank private String company;
        @NotBlank private String designation;
        private String areaOfExpertise;
        private String linkedInUrl;
        private Integer yearsOfExperience;
        private String bio;
        private String adminSummary;
    }

    @Data
    public static class StudentProfileRequest {
        @NotBlank private String fullName;
        @NotBlank private String phone;
        @NotBlank private String college;
        @NotBlank private String course;
        private String customCourse;
        private String year;
        private String city;
        private String linkedInUrl;
    }

    @Data
    @AllArgsConstructor
    public static class MessageResponse {
        private String message;
    }

    @Data
    public static class CollegeRequest {
        @NotBlank private String name;
        private String city;
        private String state;
    }
}