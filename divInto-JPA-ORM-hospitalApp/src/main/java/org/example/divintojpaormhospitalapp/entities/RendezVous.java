package org.example.divintojpaormhospitalapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RendezVous {
    @Id
    private String id;
    @Temporal(TemporalType.DATE) // to store only the date without the time
    private Date date;
    private boolean annule;
    @Enumerated(EnumType.STRING) // to store the enum as a string
    private StatusRDV status;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous") // mappedBy is the name of the field in the Consultation class
    private  Consultation consultation;
}
