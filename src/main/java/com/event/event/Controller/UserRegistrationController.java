package com.event.event.Controller;

import com.event.event.Entities.Users;
import com.event.event.Repositories.UserResRepository;
import com.event.event.Services.UserResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserRegistrationController {

    //private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    @Autowired
    private UserResService userResService;

    @PostMapping("/register/user")
    public ResponseEntity<Object> createUser(@RequestBody Users user) {
        Users result = userResService.createUser(user);

        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        //Users result = userResRepository.save(user);
        if (result.getId() > 0){
            return ResponseEntity.ok("USer Was Saved");
        }
        return ResponseEntity.status(404).body("Error, USer Not Saved");






    }
}
