package com.example.persondog;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class PersonAndDog {
    @Id
    private String id;
    private LocalDateTime date;
    private String contract;
    private String status;
    @ManyToOne (fetch= FetchType.EAGER)
    @JoinColumn (name = "Person_FK")
    private Person PersonID;

    @ManyToOne (fetch= FetchType.EAGER)
    @JoinColumn (name = "Dog_FK")
    private Dog DogID;


    public PersonAndDog(String id, Person person, Dog dog) {
        this.id = id;
        this.PersonID = person;
        this.DogID = dog;
        this.date = LocalDateTime.now();
        this.contract = person.getName() + " has " +  dog.getName();
        this.status = "active";
    }

    public String toString(){
        return this.id + " " + this.date + " " + this.contract + " " + this.status;
    }
}
