package org.example.divintojpa;

import org.example.divintojpa.Dao.entities.Patient;
import org.example.divintojpa.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		patientRepository.save(new Patient(null, "Hassan", new Date(), false, 15));
		patientRepository.save(new Patient(null, "Yassine", new Date(), false, 20));
		patientRepository.save(new Patient(null, "Omar", new Date(), true, 30));

		List<Patient> patients =patientRepository.findAll();

		patients.forEach(p->{
			System.out.println("-------------------------");
			System.out.println(p.getNom());
			System.out.println(p.getDateNaissance());
			System.out.println(p.getScore());
			System.out.println(p.isMalade());
			System.out.println("-------------------------");
		});
		System.out.println("//////////////////////////////");
		patientRepository.findById(1L).ifPresent(p->{
			System.out.println(p.getNom());
			System.out.println(p.getDateNaissance());
			System.out.println(p.getScore());
			System.out.println(p.isMalade());
		});

	}

}
