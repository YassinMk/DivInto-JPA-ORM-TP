package org.example.divintojpa.Repositories;

import org.example.divintojpa.Dao.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    public List<Patient> findByMalade(boolean nom);
    Page<Patient> findByMalade(boolean nom, Pageable pageable);
    @Query("select p from Patient p where p.nom like :n and p.score > :y")
    List<Patient> chercherPatient(@Param("n") String nom,@Param("y") int y);
}
