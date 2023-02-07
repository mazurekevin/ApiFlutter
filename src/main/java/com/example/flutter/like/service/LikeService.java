package com.example.flutter.like.service;

import com.example.flutter.like.Dto.LikeDto;

import java.util.List;

public interface LikeService {
    LikeDto createLike(LikeDto likeDto);

    void deleteLikeById(Long id);

    List<LikeDto> getLikesByIduser(Long iduser);

}
