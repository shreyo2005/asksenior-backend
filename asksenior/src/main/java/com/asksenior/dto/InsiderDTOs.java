package com.asksenior.dto;

import lombok.Data;

public class InsiderDTOs {

    @Data
    public static class GoogleAuthRequest {
        private String email;
    }

    @Data
    public static class GoogleAuthResponse {
        private Long id;
        private String email;

        public GoogleAuthResponse(Long id, String email) {
            this.id = id;
            this.email = email;
        }
    }

    @Data
    public static class CollegeRequest {
        private String collegeName;
        private String year;
        private String course;
    }

    @Data
    public static class ProfileRequest {
        private String fullName;
        private String phone;
        private String bio;
        private String photoUrl;
    }

    @Data
    public static class PayoutRequest {
        private String upiId;
        private String collegeIdNumber;
        private String adminSummary;
    }

    @Data
    public static class MessageResponse {
        private String message;
        public MessageResponse(String message) {
            this.message = message;
        }
    }
}