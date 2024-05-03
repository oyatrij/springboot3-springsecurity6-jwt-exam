package com.oyatrij.springboot3springsecurity6jwtexam.service;

import com.oyatrij.springboot3springsecurity6jwtexam.dto.CustomUserDetails;
import com.oyatrij.springboot3springsecurity6jwtexam.entity.UserEntity;
import com.oyatrij.springboot3springsecurity6jwtexam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userData = userRepository.findByUsername(username);

        if(userData != null) {
            return new CustomUserDetails(userData);
        }
        return null;
    }
}
