package org.example.divintojpaormhospitalapp.repositories;

import org.example.divintojpaormhospitalapp.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
