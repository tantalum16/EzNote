package org.example.eznote.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
   private Long id;
   private String name;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;
}
