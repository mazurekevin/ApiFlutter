package com.example.flutter.like.controller;

import com.example.flutter.comment.Dto.CommentDto;
import com.example.flutter.like.Dto.LikeDto;
import com.example.flutter.like.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/like")
public class LikeController {

    private LikeService likeService;

    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<LikeDto> createComment(@RequestBody LikeDto likeDto){
        return new ResponseEntity<>(this.likeService.createLike(likeDto), HttpStatus.CREATED);
    }

    @GetMapping("/iduser/{iduser}")
    public List<LikeDto> getLikesByIduser(@PathVariable(name = "iduser") Long iduser){
        return this.likeService.getLikesByIduser(iduser);
    }

    @PostMapping("/removeLike")
    public void removeLike(@RequestBody LikeDto likeDto){
        List<LikeDto> list = this.likeService.getLikesByIduser(likeDto.iduser);
        for (LikeDto dto : list) {
            if (likeDto.idmovie == dto.idmovie) {
                deleteLikeById(dto.id);
            }
        }

    }
    @PostMapping("/checkLike")
    public boolean checkLike(@RequestBody LikeDto likeDto){
        List<LikeDto> list = this.likeService.getLikesByIduser(likeDto.iduser);
        for (LikeDto dto : list) {
            if (likeDto.idmovie == dto.idmovie) {
                return true;
            }
        }
        return false;
    }
    @DeleteMapping("/{id}")
    public void deleteLikeById(@PathVariable(name = "id") long id){
        this.likeService.deleteLikeById(id);
    }

}
