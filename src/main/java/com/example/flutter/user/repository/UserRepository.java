package com.example.flutter.user.repository;

import com.example.flutter.user.Dto.UserDto;
import com.example.flutter.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByEmail(String email);
}
