package com.example.flutter.comment.controller;

import com.example.flutter.comment.Dto.CommentDto;
import com.example.flutter.comment.service.CommentService;
import com.example.flutter.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto){
        return new ResponseEntity<>(this.commentService.createComment(commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getCommentsById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(this.commentService.getCommentById(id), HttpStatus.OK);
    }

    @GetMapping
    public List<CommentDto> getAllComments(){
        return this.commentService.getAllComments();
    }

    @GetMapping("/idmovie/{idmovie}")
    public List<CommentDto> getCommentByIdmovie(@PathVariable(name = "idmovie") int idmovie){
        return this.commentService.getCommentByIdmovie(idmovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(name = "id") long id,@Valid @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(this.commentService.updateComment(commentDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCommentById(@PathVariable(name = "id") long id){
        this.commentService.deleteCommentById(id);
    }

}
