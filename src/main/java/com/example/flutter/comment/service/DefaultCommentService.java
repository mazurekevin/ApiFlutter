package com.example.flutter.comment.service;

import com.example.flutter.comment.Dto.CommentDto;
import com.example.flutter.comment.domain.Comment;
import com.example.flutter.comment.repository.CommentRepository;
import com.example.flutter.user.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCommentService implements CommentService {
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    public DefaultCommentService(CommentRepository commentRepository, ModelMapper modelMapper){
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);
        Comment newComment = this.commentRepository.save(comment);
        return mapToDto(newComment);
    }

    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> comments = this.commentRepository.findAll();
        return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());    }

    @Override
    public CommentDto getCommentById(long id) {
        Comment comment = this.commentRepository.getById(id);
        return mapToDto(comment);
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, long id) {
        Comment comment = this.commentRepository.getById(id);

        comment.setIdmovie(comment.getIdmovie());
        comment.setIduser(comment.getIduser());
        comment.setFirstname(comment.getFirstname());
        comment.setLastname(comment.getLastname());
        comment.setContent(comment.getContent());

        Comment updatedComment = this.commentRepository.save(comment);

        return mapToDto(updatedComment);
    }

    @Override
    public void deleteCommentById(long id) {
        Comment comment = this.commentRepository.findById(id).orElseThrow();
        this.commentRepository.delete(comment);
    }

    @Override
    public List<CommentDto> getCommentByIdmovie(int idmovie) {
        List<Comment> comments = this.commentRepository.getCommentByIdmovie(idmovie);
        return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
    }


    private CommentDto mapToDto(Comment comment){
        return modelMapper.map(comment, CommentDto.class);
    }

    private Comment mapToEntity(CommentDto commentDto){
        return modelMapper.map(commentDto, Comment.class);
    }
}
