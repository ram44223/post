package com.blog.demo.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;

    @NotNull
    private String name;
    @Email
    private String email;
}
