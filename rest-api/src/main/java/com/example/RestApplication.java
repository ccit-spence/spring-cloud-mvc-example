package com.example;


import com.example.models.Instructor;
import com.example.repositories.InstructorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(InstructorRepository repository) {
        return (args) -> {
            // create instructors
            repository.save(new Instructor("Albert", "Einstein"));
            repository.save(new Instructor("Marie", "Curie"));
            repository.save(new Instructor("Niels", "Bohr"));
            repository.save(new Instructor("Isaac", "Newton"));
            repository.save(new Instructor("Ernest", "Rutherford"));
            repository.save(new Instructor("Stephen", "Hawking"));
            repository.save(new Instructor("Max", "Born"));
            repository.save(new Instructor("Nikola", "Tesla"));

        };
    }

}
