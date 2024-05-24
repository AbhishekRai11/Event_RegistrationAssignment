package com.event.event.Controller;

import com.event.event.Entities.Users;
import com.event.event.Repositories.UserResRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserRegistrationController {
    @Autowired
    private UserResRepository userResRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/user")
    public Users createUser(@RequestBody Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userResRepository.save(user);
    }
}
