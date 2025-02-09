package com.nicolasaraujo.jobService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userService", url = "${USER_SERVICE_URL}")
public interface UserServiceClient {

    @GetMapping("/users/{id}/is-employer")
    Boolean isEmployerById(@PathVariable String id);
}
