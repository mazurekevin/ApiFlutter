package com.example.flutter.user.domain;

import jakarta.persistence.*;
import lombok.*;



@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", nullable = false)
    public String firstname;

    @Column(name = "lastname", nullable = false)
    public String lastname;

    @Column(name = "email", nullable = false)
    public String email;

    @Column(name = "password", nullable = false)
    public String password;
}
