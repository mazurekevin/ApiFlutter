package com.example.flutter.like.repository;

import com.example.flutter.like.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {
    List<Like> getLikesByIduser(Long iduser);
}
