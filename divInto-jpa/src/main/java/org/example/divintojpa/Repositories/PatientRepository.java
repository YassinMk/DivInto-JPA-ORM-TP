package org.example.divintojpa.Repositories;

import org.example.divintojpa.Dao.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
