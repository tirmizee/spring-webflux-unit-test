package com.tirmizee.service;

import com.tirmizee.model.UserModel;
import com.tirmizee.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Mono<UserModel> getUserByUsername(String username) {
        return userRepository.getByUsername(username)
                .map(user -> new UserModel(String.valueOf(user.getId()), username));
    }

}
