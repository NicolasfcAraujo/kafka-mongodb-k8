package com.nicolasaraujo.userService.model;

import com.nicolasaraujo.userService.dto.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String password;
    private UserType role; //RECRUITER or APPLICANT

    public User() {}

    public User(String id, String name, String password, UserType role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User(UserDTO userDTO) {
        this.name = userDTO.name();
        this.password = userDTO.password();
        this.role = userDTO.role();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getRole() {
        return role;
    }

    public void setRole(UserType role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, role);
    }
}
