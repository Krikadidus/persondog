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

    @ManyToMany(mappedBy = "dogs", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private List <Person> persons = new ArrayList<>();

    public Dog(String id, String name, String breed, int age) {
        this.id = id;
        this.name = name;
        this.breed = breed;
    }

    public  void addPerson(Person person){
        persons.add(person);
    }

}
