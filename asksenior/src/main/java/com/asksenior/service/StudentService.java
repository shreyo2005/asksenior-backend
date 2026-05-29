package com.asksenior.service;

import com.asksenior.dto.Dtos.*;
import com.asksenior.exception.NotFoundException;
import com.asksenior.model.Student;
import com.asksenior.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student auth(String email) {
        return repo.findByEmail(email).orElseGet(() -> {
            Student s = new Student();
            s.setEmail(email);
            return repo.save(s);
        });
    }

    public void updateProfile(Long id, StudentProfileRequest req) {
        Student s = get(id);
        s.setFullName(req.getFullName());
        s.setPhone(req.getPhone());
        s.setCollege(req.getCollege());
        s.setCourse(req.getCourse());
        s.setCustomCourse("Other".equalsIgnoreCase(req.getCourse()) ? req.getCustomCourse() : null);
        s.setYear(req.getYear());
        s.setCity(req.getCity());
        s.setLinkedInUrl(req.getLinkedInUrl());
        s.setRegisteredAt(LocalDateTime.now());
        repo.save(s);
    }

    public Student get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found with id " + id));
    }

    public Page<Student> search(String q, Pageable pageable) {
        if (q == null || q.isBlank()) return repo.findAll(pageable);
        return repo.findByFullNameContainingIgnoreCaseOrCollegeContainingIgnoreCaseOrEmailContainingIgnoreCase(
                q, q, q, pageable);
    }

    public long count() { return repo.count(); }

    public List<Student> all() { return repo.findAll(); }
}
