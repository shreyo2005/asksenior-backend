package com.asksenior.service;

import com.asksenior.dto.Dtos.*;
import com.asksenior.exception.NotFoundException;
import com.asksenior.model.Insider;
import com.asksenior.repository.InsiderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InsiderService {

    private final InsiderRepository repo;

    public InsiderService(InsiderRepository repo) {
        this.repo = repo;
    }

    public Insider auth(String email) {
        return repo.findByEmail(email).orElseGet(() -> {
            Insider i = new Insider();
            i.setEmail(email);
            return repo.save(i);
        });
    }

    public void updateCollege(Long id, InsiderCollegeRequest req) {
        Insider i = get(id);
        i.setCollege(req.getCollege());
        i.setCourse(req.getCourse());
        i.setCustomCourse("Other".equalsIgnoreCase(req.getCourse()) ? req.getCustomCourse() : null);
        i.setYear(req.getYear());
        repo.save(i);
    }

    public void updateProfile(Long id, InsiderProfileRequest req) {
        Insider i = get(id);
        i.setFullName(req.getFullName());
        i.setPhone(req.getPhone());
        i.setBio(req.getBio());
        i.setLinkedInUrl(req.getLinkedInUrl());
        repo.save(i);
    }

    public void updatePayout(Long id, InsiderPayoutRequest req) {
        Insider i = get(id);
        i.setUpiId(req.getUpiId());
        i.setCollegeIdNumber(req.getCollegeIdNumber());
        i.setAdminSummary(req.getAdminSummary());
        i.setRegisteredAt(LocalDateTime.now());
        repo.save(i);
    }

    public void markOnboardingWatched(Long id) {
        Insider i = get(id);
        i.setOnboardingWatched(true);
        repo.save(i);
    }

    public Insider get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Insider not found with id " + id));
    }

    public Page<Insider> search(String q, Pageable pageable) {
        if (q == null || q.isBlank()) return repo.findAll(pageable);
        return repo.findByFullNameContainingIgnoreCaseOrCollegeContainingIgnoreCaseOrEmailContainingIgnoreCase(
                q, q, q, pageable);
    }

    public long count() { return repo.count(); }

    public java.util.List<Insider> all() { return repo.findAll(); }
}