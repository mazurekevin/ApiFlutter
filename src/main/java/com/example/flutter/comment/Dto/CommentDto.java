package com.example.flutter.comment.Dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CommentDto {

    public Long id;

    @NotEmpty(message = "iduser should not be null or empty")
    public Long iduser;

    @NotEmpty(message = "idmovie should not be null or empty")
    public int idmovie;

    @NotEmpty(message = "firstname should not be null or empty")
    public String firstname;

    @NotEmpty(message = "lastname should not be null or empty")
    public String lastname;

    @NotEmpty(message = "content should not be null or empty")
    public String content;
}
