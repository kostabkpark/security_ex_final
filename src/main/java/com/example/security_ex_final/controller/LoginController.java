package com.example.security_ex_final.controller;

import com.example.security_ex_final.form.MyUserForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class LoginController {

  @GetMapping("/login")
  public String login(Model model) {
    MyUserForm myUser = new MyUserForm();
    model.addAttribute("myuser", myUser);
    return "login";
  }
//
//  @PostMapping("login")
//
}
