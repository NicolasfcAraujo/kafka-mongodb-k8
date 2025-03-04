package com.nicolasaraujo.userService.repository;

import com.nicolasaraujo.userService.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
