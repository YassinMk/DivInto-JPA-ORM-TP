package org.example.divintojpaormhospitalapp.service;

import org.example.divintojpaormhospitalapp.entities.Consultation;
import org.example.divintojpaormhospitalapp.entities.Medecin;
import org.example.divintojpaormhospitalapp.entities.Patient;
import org.example.divintojpaormhospitalapp.entities.RendezVous;
import org.springframework.stereotype.Service;

@Service
public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
    RendezVous findRendezVousById(String id);
    Patient findPatientById(Long id);
    Patient findPatientByNom(String nom);
    Medecin findMedecinById(Long id);
    Medecin findMedecinByNom(String nom);


}
