package com.tirmizee.service;

import com.tirmizee.entity.User;
import com.tirmizee.model.UserModel;
import com.tirmizee.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void getUserByUsernameTest() {
        String username = "tirmizee";
        User mockUser = new User(
                1,
                "tirmizee",
                "{bcrypt}$2a$10$kvHzEVdElMw.7IcTjEAZf.r/x6tANA0WxhD0cl6RCN7RDzsUdvxCe",
                "tirmizee@gmail.com",
                true,
                LocalDateTime.parse("2024-01-20T15:36:34.065603"),
                null
        );

        when(userRepository.getByUsername(username)).thenReturn(Mono.just(mockUser));

        Mono<UserModel> result = userService.getUserByUsername(username);

        StepVerifier.create(result)
                .expectNextMatches(user -> user.getUsername().equals(username))
                .verifyComplete();
    }

}
