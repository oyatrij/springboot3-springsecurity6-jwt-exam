package com.oyatrij.springboot3springsecurity6jwtexam.repository;

import com.oyatrij.springboot3springsecurity6jwtexam.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Boolean existsByUsername(String userName);
}
