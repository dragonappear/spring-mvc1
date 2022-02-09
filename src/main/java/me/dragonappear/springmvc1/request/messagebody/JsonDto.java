package me.dragonappear.springmvc1.request.messagebody;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JsonDto {
    private String username;
    private String age;
}
