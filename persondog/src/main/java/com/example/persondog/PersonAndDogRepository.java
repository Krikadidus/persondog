package com.example.persondog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonAndDogRepository extends JpaRepository<PersonAndDog, String> {
}
