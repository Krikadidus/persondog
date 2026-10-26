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
    public CommandLineRunner commandLineRunner (PersonRepository personRepository, DogRepository dogRepository, PersonAndDogRepository personAndDogRepository) {
        return args -> {
            Person person = new Person("1", "Ji", 2);
            Person person2 = new Person("2", "JE", 3);

            Dog dog = new Dog("1", "Kur", "shpitz", 4);
            Dog dog2 = new Dog("2", "Ruk", "shpitz", 2);

            PersonAndDog first = new PersonAndDog("1",person, dog);
            PersonAndDog third = new PersonAndDog("2",person, dog2);
            PersonAndDog fourth = new PersonAndDog("3",person2, dog);
            PersonAndDog second = new PersonAndDog("4",person2, dog2);



            personRepository.save(person2);
            personRepository.save(person);
            dogRepository.save(dog);
            dogRepository.save(dog2);
            personAndDogRepository.save(first);
            personAndDogRepository.save(second);
            personAndDogRepository.save(third);
            personAndDogRepository.save(fourth);

        };
    }
}
