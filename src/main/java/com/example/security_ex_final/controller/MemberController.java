package com.example.security_ex_final.controller;

import com.example.security_ex_final.form.MyUserForm;
import com.example.security_ex_final.service.SignupMyUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {
  private final SignupMyUserService signupMyUserService;

  @GetMapping("/member")
  public String member() {
    return "index";
  }

  @GetMapping("/signup")
  public String signup(Model model) {
    model.addAttribute("myuser", new MyUserForm());
    return "signup";
  }

  @PostMapping("/signup")
  public String signup(@ModelAttribute MyUserForm form) {
    signupMyUserService.signUp(form);
    return "redirect:/login";
  }
}
