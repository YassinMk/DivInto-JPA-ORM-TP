package org.example.divintojpaormhospitalapp.repositories;

import org.example.divintojpaormhospitalapp.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
