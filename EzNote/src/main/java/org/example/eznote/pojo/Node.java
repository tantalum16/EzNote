package org.example.eznote.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Node {
   private Long id;
   private Long noteId;
   private String title;
   private Double positionX;
   private Double positionY;
   private Double size;
   private String color;
   private String style;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;
}
