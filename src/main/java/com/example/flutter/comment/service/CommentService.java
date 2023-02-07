package com.example.flutter.comment.service;

import com.example.flutter.comment.Dto.CommentDto;
import com.example.flutter.comment.domain.Comment;
import com.example.flutter.user.Dto.UserDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto);
    List<CommentDto> getAllComments();
    CommentDto getCommentById(long id);
    CommentDto updateComment(CommentDto commentDto, long id);
    void deleteCommentById(long id);

    List<CommentDto> getCommentByIdmovie(int idmovie);
}
