package com.oyatrij.springboot3springsecurity6jwtexam.service;

import com.oyatrij.springboot3springsecurity6jwtexam.dto.JoinDTO;
import com.oyatrij.springboot3springsecurity6jwtexam.entity.UserEntity;
import com.oyatrij.springboot3springsecurity6jwtexam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDTO joinDTO) {

        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);

        if(isExist) {
            return;
        }

        UserEntity data = new UserEntity();
        data.setUsername(username);
        /*
            SecurityConfig에서 BCryptPasswordEncoder를 Bean으로 주입해놨기 때문에
            암호화 할 때 가져다 쓸 수 있다.
            @Bean
            public BCryptPasswordEncoder bCryptPasswordEncoder() {
                return new BCryptPasswordEncoder();
            }
        * */
        data.setPassword(bCryptPasswordEncoder.encode(password));
        //Springsecurity에서 'ROLE_' 을 자동으로 탐지
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }
}
