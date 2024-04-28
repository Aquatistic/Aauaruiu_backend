package com.aquarium.aquarium_backend.databaseTables;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "AppUser")
public class User {
    public User() {
    }
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
        if (this == comparedObject)
            return true;
        if (comparedObject == null || comparedObject.getClass() != User.class)
            return false;
        var comparedEmployee = (User) comparedObject;
        return userId == comparedEmployee.userId && Objects.equals(userName, comparedEmployee.userName)
                && Objects.equals(email, comparedEmployee.email) && checkPassword(comparedEmployee.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, email, password);
    }

    public Long getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserEmail() {
        return this.email;
    }
//    @JsonIgnore
    public String getUserPassword() {
        return this.password;
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
}
