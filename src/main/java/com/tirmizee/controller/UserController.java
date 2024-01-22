package com.tirmizee.controller;

import com.tirmizee.model.UserModel;
import com.tirmizee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{username}")
    public Mono<UserModel> getUser(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

}
