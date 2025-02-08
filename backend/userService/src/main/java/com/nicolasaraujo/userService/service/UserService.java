package com.nicolasaraujo.userService.service;

import com.nicolasaraujo.userService.dto.UserDTO;
import com.nicolasaraujo.userService.model.User;
import com.nicolasaraujo.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User createUser(UserDTO userDTO) {
        User user = new User(userDTO);

        return userRepository.save(user);
    }

    public Optional<User> updateUser(String id, UserDTO userDTO) {
        return userRepository.findById(id).map(user -> {
            user.setName(userDTO.name());
            user.setPassword(userDTO.password());
            user.setRole(userDTO.role());

            return userRepository.save(user);
        });
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
