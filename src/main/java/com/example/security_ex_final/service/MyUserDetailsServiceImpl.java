package com.example.security_ex_final.service;

import com.example.security_ex_final.entity.MyUser;
import com.example.security_ex_final.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsServiceImpl implements UserDetailsService {
  private final MyUserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    MyUser myUser = userRepository.findByUsername(username);

    if(myUser == null) {
      return null;
    } else {
      return User.builder()
          .username(myUser.getUsername())
          .password(myUser.getPassword())
          .authorities(myUser.getAuthority())
          .build();
    }
  }
}
