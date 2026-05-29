package com.asksenior.controller;

import com.asksenior.dto.InsiderDTOs.*;
import com.asksenior.model.Insider;
import com.asksenior.service.InsiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class InsiderController {

    @Autowired
    private InsiderService insiderService;

    @PutMapping("/insider/{id}/college")
    public MessageResponse updateCollege(@PathVariable Long id, @RequestBody CollegeRequest request) {
        insiderService.updateCollege(id, request);
        return new MessageResponse("College info saved");
    }

    @PutMapping("/insider/{id}/profile")
    public MessageResponse updateProfile(@PathVariable Long id, @RequestBody ProfileRequest request) {
        insiderService.updateProfile(id, request);
        return new MessageResponse("Profile saved");
    }

    @PutMapping("/insider/{id}/payout")
    public MessageResponse updatePayout(@PathVariable Long id, @RequestBody PayoutRequest request) {
        insiderService.updatePayout(id, request);
        return new MessageResponse("Payout info saved");
    }

    @GetMapping("/admin/insiders")
    public List<Insider> getAllInsiders() {
        return insiderService.getAllInsiders();
    }
}