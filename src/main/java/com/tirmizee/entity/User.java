package com.tirmizee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Boolean enabled;
    private LocalDateTime createdDate;
    private LocalDateTime lastLogin;

}
