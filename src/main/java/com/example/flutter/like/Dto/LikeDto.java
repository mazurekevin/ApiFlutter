package com.example.flutter.like.Dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class LikeDto {

    public Long id;

    @NotEmpty(message = "iduser should not be null or empty")
    public Long iduser;

    @NotEmpty(message = "idmovie should not be null or empty")
    public int idmovie;
}
