package com.nicolasaraujo.userService.dto;

public record UserDTO(
        String name,
        String password,
        String role
) {
}
