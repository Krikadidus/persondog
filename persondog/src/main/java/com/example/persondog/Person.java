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
    @OneToMany (mappedBy ="PersonID",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PersonAndDog> listOfPersonAndDogs = new ArrayList<>();

    public Person(String id, String name, int i) {
        this.id = id;
        this.name = name;
        this.age = i;
    }

    public void add(PersonAndDog personanddog) {
        listOfPersonAndDogs.add(personanddog);
    }

    public String toString(){
        String text ="";
        for (PersonAndDog personanddog : listOfPersonAndDogs){
             text+=this.id + " " + this.name + " " + this.age + " " + personanddog.getContract();
        }
        return text;
    }
}
