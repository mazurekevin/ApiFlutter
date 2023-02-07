package com.example.flutter.like.service;

import com.example.flutter.comment.Dto.CommentDto;
import com.example.flutter.comment.domain.Comment;
import com.example.flutter.like.Dto.LikeDto;
import com.example.flutter.like.domain.Like;
import com.example.flutter.like.repository.LikeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultLikeService implements LikeService{

    private ModelMapper modelMapper;

    private LikeRepository likeRepository;

    public DefaultLikeService(ModelMapper modelMapper,LikeRepository likeRepository){
        this.likeRepository = likeRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public LikeDto createLike(LikeDto likeDto) {
        Like like = mapToEntity(likeDto);
        Like newLike = this.likeRepository.save(like);
        return mapToDto(newLike);
    }

    @Override
    public void deleteLikeById(Long id) {
        Like like = this.likeRepository.findById(id).orElseThrow();
        this.likeRepository.delete(like);
    }

    @Override
    public List<LikeDto> getLikesByIduser(Long iduser) {
        List<Like> likes = this.likeRepository.getLikesByIduser(iduser);
        return likes.stream().map(like -> mapToDto(like)).collect(Collectors.toList());
    }

    private LikeDto mapToDto(Like like){
        return modelMapper.map(like, LikeDto.class);
    }

    private Like mapToEntity(LikeDto likeDto){
        return modelMapper.map(likeDto, Like.class);
    }
}
