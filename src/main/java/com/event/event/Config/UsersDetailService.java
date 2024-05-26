package com.event.event.Config;


import com.event.event.Entities.Users;
import com.event.event.Repositories.UserResRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Configuration
public class UsersDetailService implements UserDetailsService {

    @Autowired
    private UserResRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = repository.findByUsername(username);
        return user.map(UserDetail::new).orElseThrow(()->new UsernameNotFoundException("User Does Not Exist"));
    }

//    private String[] getRoles(Users user) {
//        if (user.getRole() == null) {
//            return new String[]{"user"};
//        }
//        return user.getRole().split(",");
//    }
}
