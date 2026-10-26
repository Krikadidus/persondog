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
public class Dog {

    @Id
    private String id;
    private String name;
    private String breed;
    private int age;

    @ManyToOne (fetch= FetchType.LAZY)
    @JoinColumn(name = "Person_FK")
    private Person personID;


}
