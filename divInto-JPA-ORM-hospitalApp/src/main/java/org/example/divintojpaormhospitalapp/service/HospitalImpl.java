package org.example.divintojpaormhospitalapp.service;

import org.example.divintojpaormhospitalapp.entities.Consultation;
import org.example.divintojpaormhospitalapp.entities.Medecin;
import org.example.divintojpaormhospitalapp.entities.Patient;
import org.example.divintojpaormhospitalapp.entities.RendezVous;
import org.example.divintojpaormhospitalapp.repositories.ConsultationRepository;
import org.example.divintojpaormhospitalapp.repositories.MedecinRepository;
import org.example.divintojpaormhospitalapp.repositories.PatientRepository;
import org.example.divintojpaormhospitalapp.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class HospitalImpl implements IHospitalService{
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public RendezVous findRendezVousById(String id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient findPatientByNom(String nom) {
        return patientRepository.findByNom(nom);
    }

    @Override
    public Medecin findMedecinById(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    @Override
    public Medecin findMedecinByNom(String nom) {
        return medecinRepository.findByNom(nom);
    }
}
