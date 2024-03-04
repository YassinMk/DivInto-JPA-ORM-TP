package org.example.divintojpaormhospitalapp;

import org.example.divintojpaormhospitalapp.entities.Medecin;
import org.example.divintojpaormhospitalapp.entities.Patient;
import org.example.divintojpaormhospitalapp.entities.RendezVous;
import org.example.divintojpaormhospitalapp.entities.StatusRDV;
import org.example.divintojpaormhospitalapp.repositories.MedecinRepository;
import org.example.divintojpaormhospitalapp.repositories.PatientRepository;
import org.example.divintojpaormhospitalapp.repositories.RendezVousRepository;
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
    CommandLineRunner start(PatientRepository patientRepository , MedecinRepository medecinRepository , RendezVousRepository rendezVousRepository){
        return args -> {
            Stream.of("Amine", "Mohamed", "Yassine", "Oussama").forEach(nom -> {
                Patient patient = new Patient();
                patient.setNom(nom);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                patientRepository.save(patient);
            });
            Stream.of("aymane","Anass","Younes").forEach(nom -> {
                Medecin medecin = new Medecin();
                medecin.setNom(nom);
                medecin.setSpecialite(Math.random() > 0.5 ? "Cardiologue" : "Dentiste");
                medecin.setEmail(nom + "@gmail.com");
                medecinRepository.save(medecin);

            });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Amine");
            System.out.println("******************");
            Medecin medecin = medecinRepository.findByNom("aymane");
            System.out.println("******************");
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setAnnule(false);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVousRepository.save(rendezVous);


        };
    }

}
