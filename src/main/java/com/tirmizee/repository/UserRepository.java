package com.tirmizee.repository;

import com.tirmizee.entity.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends R2dbcRepository<User, Integer> {

    Mono<User> getByUsername(String username);

}
