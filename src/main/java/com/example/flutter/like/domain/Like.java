package com.example.flutter.like.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "likemovie")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idmovie", nullable = false)
    public int idmovie;

    @Column(name = "iduser", nullable = false)
    public Long iduser;

}
