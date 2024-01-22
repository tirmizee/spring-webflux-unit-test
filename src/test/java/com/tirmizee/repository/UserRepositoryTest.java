package com.tirmizee.repository;

import com.tirmizee.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@DataR2dbcTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGetByUsername() {
        String username = "tirmizee";

        Mono<User> userMono = userRepository.getByUsername(username);

        StepVerifier.create(userMono)
                .assertNext(user -> username.equals(user.getUsername()))
                .verifyComplete();
    }
}
