package com.tirmizee.controller;

import com.tirmizee.model.UserModel;
import com.tirmizee.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@WebFluxTest(UserController.class)
public class ApiControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUser() {
        String username = "tirmizee";
        UserModel mockUserModel = new UserModel("123", username);

        when(userService.getUserByUsername(username)).thenReturn(Mono.just(mockUserModel));

        webTestClient.get().uri("/users/{username}", username)
                .exchange()
                .expectStatus().isOk()
                .expectBody(UserModel.class)
                .isEqualTo(mockUserModel);
    }

}
