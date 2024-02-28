package org.example.divintojpa;

import org.example.divintojpa.Dao.entities.Patient;
import org.example.divintojpa.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;
import java.util.logging.ConsoleHandler;

@SpringBootApplication
public class DivIntoJpaApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(DivIntoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			patientRepository.save(new Patient(null, "Patient"+i, new Date(), i%2==0,(int)(Math.random()*1000)));
		}

		Page<Patient> patients = patientRepository.findAll(PageRequest.of(0, 5));
		System.out.println("totale pages : "+patients.getTotalPages());
		System.out.println("totale elements : "+patients.getTotalElements());
		System.out.println("num Page  : "+patients.getNumber());
		List <Patient> content = patients.getContent();
		content.forEach(p->{
			System.out.println("-------------------------");
			System.out.println(p.getId());
			System.out.println(p.getNom());
			System.out.println(p.getDateNaissance());
			System.out.println(p.getScore());
			System.out.println(p.isMalade());
			System.out.println("-------------------------");
		});
		System.out.println("//////////////////////////////");
		Page<Patient> patientNonMalade = patientRepository.findByMalade(false, PageRequest.of(0, 5));
		patientNonMalade.forEach(p->{
			System.out.println("----------Patient Non Malade-----------------");
			System.out.println(p.getId());
			System.out.println(p.getNom());
			System.out.println(p.getDateNaissance());
			System.out.println(p.getScore());
			System.out.println(p.isMalade());
			System.out.println("-------------------------");
		});
		System.out.println("//////////////////////////////");
		Patient patient = patientRepository.findById(1L).orElse(null);
		System.out.println(patient.getNom());
		System.out.println(patient.getDateNaissance());
		System.out.println(patient.getScore());
		System.out.println(patient.isMalade());

		System.out.println("//////////////////////////////");
		patient.setScore(860);
		patientRepository.save(patient);
		patientRepository.deleteById(1L);
		System.out.println("//////////////////////////////");

	}

}
