package maenset.patientsmvc;

import maenset.patientsmvc.entities.Patient;
import maenset.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null, "Hassan",new Date(),false,112));
            patientRepository.save(new Patient(null, "Wiam",new Date(),true,321));
            patientRepository.save(new Patient(null, "Walid",new Date(),false,178));
            patientRepository.save(new Patient(null, "Hanae",new Date(),true,320));

            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getNom());
            });


        };
    }
}
