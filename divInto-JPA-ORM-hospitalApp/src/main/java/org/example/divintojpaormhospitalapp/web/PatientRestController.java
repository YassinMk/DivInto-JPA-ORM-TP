package org.example.divintojpaormhospitalapp.web;

import org.example.divintojpaormhospitalapp.entities.Patient;
import org.example.divintojpaormhospitalapp.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
}
