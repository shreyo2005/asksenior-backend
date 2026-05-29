package com.asksenior.controller;

import com.asksenior.dto.InsiderDTOs.*;
import com.asksenior.service.InsiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private InsiderService insiderService;

    @PostMapping("/google")
    public GoogleAuthResponse googleAuth(@RequestBody GoogleAuthRequest request) {
        return insiderService.googleAuth(request.getEmail());
    }
}