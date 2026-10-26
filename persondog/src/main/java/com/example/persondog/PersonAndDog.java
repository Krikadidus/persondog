package com.example.persondog;

import jakarta.persistence.*;
import lombok.*;


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
    @ManyToOne (fetch= FetchType.LAZY)
    @JoinColumn (name = "Person_FK")
    private Person personID;

    @ManyToOne (fetch= FetchType.LAZY)
    @JoinColumn (name = "Dog_FK")
    private Dog dogID;



}
