package org.example.eznote.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
