package org.example.eznote.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    private Long id;
    private Long userId;
    private String title;
    private String content;//markdown文件url，使用alioss存储
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
