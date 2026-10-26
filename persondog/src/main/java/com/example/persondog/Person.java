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
public class Person {

    @Id
    private String id;
    private String name;
    private int age;

    @ManyToMany( cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinTable( name = "PersonAndDogs",
            joinColumns = @JoinColumn(name = "Person_id"),
            inverseJoinColumns = @JoinColumn (name ="Dog_id"))
    private List <Dog> dogs = new ArrayList<>();

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public void addDog(Dog dog){
        dogs.add(dog);
    }

}
