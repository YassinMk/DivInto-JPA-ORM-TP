package org.example.divintojpaormhospitalapp;

import org.example.divintojpaormhospitalapp.entities.*;
import org.example.divintojpaormhospitalapp.repositories.ConsultationRepository;
import org.example.divintojpaormhospitalapp.repositories.MedecinRepository;
import org.example.divintojpaormhospitalapp.repositories.PatientRepository;
import org.example.divintojpaormhospitalapp.repositories.RendezVousRepository;
import org.example.divintojpaormhospitalapp.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class DivIntoJpaOrmHospitalAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DivIntoJpaOrmHospitalAppApplication.class, args);
    }
    @Bean //notation to make the method a bean in the spring container
    CommandLineRunner start(IHospitalService hospitalService){
        return args -> {
            Stream.of("Amine", "Mohamed", "Yassine", "Oussama").forEach(nom -> {
                Patient patient = new Patient();
                patient.setNom(nom);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                hospitalService.savePatient(patient);
            });
            Stream.of("aymane","Anass","Younes").forEach(nom -> {
                Medecin medecin = new Medecin();
                medecin.setNom(nom);
                medecin.setSpecialite(Math.random() > 0.5 ? "Cardiologue" : "Dentiste");
                medecin.setEmail(nom + "@gmail.com");
                hospitalService.saveMedecin(medecin);

            });
            System.out.println("******************");
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Amine");
            Medecin medecin = medecinRepository.findByNom("aymane");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setAnnule(false);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            rendezVous.setStatus(StatusRDV.PENDING);
            hospitalService.saveRendezVous(rendezVous);
            System.out.println("******************");
            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("diabete");
            hospitalService.saveConsultation(consultation);




        };
    }

}
