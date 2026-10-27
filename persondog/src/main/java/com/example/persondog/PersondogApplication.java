package com.example.persondog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersondogApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersondogApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner (PersonRepository personRepository, DogRepository dogRepository) {
        return args -> {
            Person person = new Person("1", "Ji", 2);

            Dog dog = new Dog("1", "Kur", "shpitz", 4, person);

            personRepository.save(person);
            dogRepository.save(dog);

        };
    }
}
