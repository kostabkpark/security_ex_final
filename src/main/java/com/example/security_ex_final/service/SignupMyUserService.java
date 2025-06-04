package com.example.security_ex_final.service;

import com.example.security_ex_final.entity.MyUser;
import com.example.security_ex_final.form.MyUserForm;
import com.example.security_ex_final.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SignupMyUserService {
  // 사용자 등록 (password - 암호화)
  private final PasswordEncoder passwordEncoder;
  private final MyUserRepository myUserRepository;

  public String signUp(MyUserForm form) {
    validateDuplicateUser(form);
    MyUser myuser = MyUser.createUser(form, passwordEncoder);
    myUserRepository.save(myuser);
    return myuser.getUsername();
  }

  private void validateDuplicateUser(MyUserForm form) {
    MyUser byUsername = myUserRepository.findByUsername(form.getUserid());
    if(byUsername != null) {
      throw new IllegalStateException("이미 존재하는 회원명입니다.");
    }
  }
}
