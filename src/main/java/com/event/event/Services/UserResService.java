package com.event.event.Services;

import com.event.event.Entities.Users;
import com.event.event.Repositories.UserResRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserResService {

    @Autowired
    UserResRepository userResRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users createUser(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Users result=userResRepository.save(user);
        return result;
    }
}
