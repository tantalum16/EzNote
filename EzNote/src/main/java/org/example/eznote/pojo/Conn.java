package org.example.eznote.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Conn {
    private Long id;
    private Long sourceNodeId;
    private Long targetNodeId;
    private String type;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
