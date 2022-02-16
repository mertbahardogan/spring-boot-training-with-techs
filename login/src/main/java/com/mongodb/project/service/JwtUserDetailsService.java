package com.mongodb.project.service;

import java.util.ArrayList;

import com.mongodb.project.common.exceptions.UsernameNotFoundException;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @SneakyThrows(Exception.class)
    @Override
    public UserDetails loadUserByUsername(String username) {
        if ("loginexample".equals(username)) {
            return new User("loginexample", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw UsernameNotFoundException.createWith(username);
        }
    }
}