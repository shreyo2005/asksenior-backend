package com.asksenior.service;

import com.asksenior.dto.InsiderDTOs.*;
import com.asksenior.model.Insider;
import com.asksenior.repository.InsiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InsiderService {

    @Autowired
    private InsiderRepository insiderRepository;

    public GoogleAuthResponse googleAuth(String email) {
        Insider insider = insiderRepository.findByEmail(email)
                .orElseGet(() -> {
                    Insider newInsider = new Insider();
                    newInsider.setEmail(email);
                    return insiderRepository.save(newInsider);
                });
        return new GoogleAuthResponse(insider.getId(), insider.getEmail());
    }

    public void updateCollege(Long id, CollegeRequest req) {
        Insider insider = insiderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insider not found"));
        insider.setCollegeName(req.getCollegeName());
        insider.setYear(req.getYear());
        insider.setCourse(req.getCourse());
        insiderRepository.save(insider);
    }

    public void updateProfile(Long id, ProfileRequest req) {
        Insider insider = insiderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insider not found"));
        insider.setFullName(req.getFullName());
        insider.setPhone(req.getPhone());
        insider.setBio(req.getBio());
        insider.setPhotoUrl(req.getPhotoUrl());
        insiderRepository.save(insider);
    }

    public void updatePayout(Long id, PayoutRequest req) {
        Insider insider = insiderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insider not found"));
        insider.setUpiId(req.getUpiId());
        insider.setCollegeIdNumber(req.getCollegeIdNumber());
        insider.setAdminSummary(req.getAdminSummary());
        insider.setRegisteredAt(LocalDateTime.now());
        insiderRepository.save(insider);
    }

    public List<Insider> getAllInsiders() {
        return insiderRepository.findAll();
    }
}