package com.example.security_ex_final.entity;

import com.example.security_ex_final.form.MyUserForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyUser {
  @Id
  @Column(length = 20)
  private String username;
  @Column(length = 255)
  private String password;
 // @Enumerated(EnumType.STRING)
  @Column(length = 10)
  private String authority;
  @Column(length = 20)
  private String displayName;
  @Column(length = 20)
  private String phoneNumber;

  public static MyUser createUser(MyUserForm form, PasswordEncoder passwordEncoder) {
    return new MyUser(form.getUserid(), passwordEncoder.encode(form.getPwd()), "USER", null, null);
  }
}
