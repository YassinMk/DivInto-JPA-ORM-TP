package org.example.divintojpaormhospitalapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date dateNaissance;
    private boolean malade;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY) // mappedBy is the name of the field in the RendezVous class
    private Collection<RendezVous> rendezVous;
}
