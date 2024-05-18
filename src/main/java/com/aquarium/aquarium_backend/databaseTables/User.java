package com.aquarium.aquarium_backend.databaseTables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "AppUser")
public class User implements UserDetails {
  public User() {}

  private @Id @GeneratedValue Long userId;
  private String userName;
  private String email;
  private String password;

  public User(String userName, String email, String password) {
    this.userName = userName;
    this.email = email;
    this.password = password;
    // We should probably store passwords hashed, but i doubt it should be
    // implemented here
  }

  private boolean checkPassword(String password) {
    return this.password.equals(password);
  }

  @Override
  public boolean equals(Object comparedObject) {
    if (this == comparedObject) return true;
    if (comparedObject == null || comparedObject.getClass() != User.class) return false;
    var comparedEmployee = (User) comparedObject;
    return userId == comparedEmployee.userId
        && Objects.equals(userName, comparedEmployee.userName)
        && Objects.equals(email, comparedEmployee.email)
        && checkPassword(comparedEmployee.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, userName, email, password);
  }

  public Long getUserId() {
    return this.userId;
  }

  public String getUserEmail() {
    return this.email;
  }


  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setUserEmail(String email) {
    this.email = email;
  }

  public void setUserPassword(String password) {
    this.password = password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  @JsonIgnore
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }
}
