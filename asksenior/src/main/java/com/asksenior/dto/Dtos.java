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

    // ---- Insider (current student) ----
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

    // ---- Mentor (professional) ----
    @Data
    public static class MentorProfileRequest {
        @NotBlank private String fullName;
        @NotBlank private String phone;
        @NotBlank private String company;
        @NotBlank private String designation;

        // Work email is MANDATORY and must be a valid email
        @NotBlank(message = "Work email is required")
        @Email(message = "Please provide a valid work email")
        private String workEmail;

        private String areaOfExpertise;
        private String linkedInUrl;
        private Integer yearsOfExperience;
        private String bio;
        private String adminSummary;
    }

    // ---- Student (seeker) ----
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

        // College email is OPTIONAL — but if present, must be valid format
        @Email(message = "Please provide a valid college email")
        private String collegeEmail;
    }

    // ---- UPI verification ----
    @Data
    public static class UpiRequest {
        @NotBlank private String upiId;
    }

    @Data
    @AllArgsConstructor
    public static class UpiResponse {
        private String upiId;
        private String status;            // VERIFIED | PENDING | FAILED
        private String accountHolderName; // null in format-only mode
        private String message;
    }

    @Data
    @AllArgsConstructor
    public static class MessageResponse {
        private String message;
    }

    @Data
    @AllArgsConstructor
    public static class UploadResponse {
        private String message;
        private String path;
    }

    @Data
    public static class CollegeRequest {
        @NotBlank private String name;
        private String city;
        private String state;
    }
}