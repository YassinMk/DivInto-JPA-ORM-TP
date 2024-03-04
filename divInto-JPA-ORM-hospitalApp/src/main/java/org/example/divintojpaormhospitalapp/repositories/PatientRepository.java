package org.example.divintojpaormhospitalapp.repositories;

import org.example.divintojpaormhospitalapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>{
}
