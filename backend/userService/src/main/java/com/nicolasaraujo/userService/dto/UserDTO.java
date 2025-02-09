package com.nicolasaraujo.userService.dto;

import com.nicolasaraujo.userService.model.UserType;

public record UserDTO(
        String name,
        String password,
        UserType role
) {
}
