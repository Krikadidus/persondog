package com.example.persondog;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Dog {

    @Id
    private String id;
    private String name;
    private String breed;
    private int age;
    @OneToMany (mappedBy ="DogID", cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private List<PersonAndDog> listOfPersonAndDogs = new ArrayList<>();

    public Dog(String id, String name, String rasa, int i) {
        this.id = id;
        this.name = name;
        this.breed = rasa;
        this.age = i;
    }

    public void add(PersonAndDog personanddog) {
        listOfPersonAndDogs.add(personanddog);
    }
}
