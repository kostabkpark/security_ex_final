package com.example.security_ex_final.repository;

import com.example.security_ex_final.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, String> {
  MyUser findByUsername(String username);
}
