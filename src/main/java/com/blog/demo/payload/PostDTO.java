package com.blog.demo.payload;

import com.blog.demo.entity.Comment;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostDTO {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty @Size(min = 3, message = "title must be greater than 3 characters") String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty @Size(min = 3, message = "title must be greater than 3 characters") String title) {
        this.title = title;
    }

    public @NotEmpty @Size(min = 3, message = "title must be greater than 3 characters") String getDescription() {
        return description;
    }

    public void setDescription(@NotEmpty @Size(min = 3, message = "title must be greater than 3 characters") String description) {
        this.description = description;
    }

    public @NotNull String getContent() {
        return content;
    }

    public void setContent(@NotNull String content) {
        this.content = content;
    }

    private Long id;
    @NotEmpty
    @Size(min=3,message="title must be greater than 3 characters")
    private String title;

    @NotEmpty
    @Size(min=3,message="title must be greater than 3 characters")
    private String description;

    @NotNull
    private String content;

    private List<Comment> comments = new ArrayList<>();


}
