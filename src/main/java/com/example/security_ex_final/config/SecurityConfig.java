package com.example.security_ex_final.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(req -> req
            .requestMatchers("/login","/signup").permitAll()
            .anyRequest().authenticated())
        .csrf(c -> c.disable())
        .formLogin(form -> form
            .loginPage("/login")
            .loginProcessingUrl("/login_process")
            .usernameParameter("userid")
            .passwordParameter("pwd")
            .defaultSuccessUrl("/member", true)
//            .successHandler((request, response, authentication) -> {
//              Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//              response.sendRedirect("/member");
//            })
            .failureHandler((request, response, exception) -> {
              log.info("Login failed: {} " , exception.getMessage());
              response.sendRedirect("/login?error");
            }))
        .logout(Customizer.withDefaults());

        return http.build();
  }
}
