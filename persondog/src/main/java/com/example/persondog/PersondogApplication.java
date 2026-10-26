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
            Person person2 = new Person("2", "Second", 54);

            Dog dog = new Dog("1", "Kur", "shpitz", 4);
            Dog dog2 = new Dog("2", "Ruk", "shpitz", 2);

            person.addDog(dog2);
            person.addDog(dog);
            dog.addPerson(person2);
            dog.addPerson(person);
            personRepository.save(person);
            personRepository.save(person2);
            dogRepository.save(dog);
            dogRepository.save(dog2);
        };
    }
}
