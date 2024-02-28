package org.example.divintojpa.Dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    private int score;
}
