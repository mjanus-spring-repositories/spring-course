package com.mjanus.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @ManyToOne
    @JoinColumn(name = "subtask_id")
    private SubTask subTask;

    public void generateRandomPerson(){
        Random random = new Random();
        int randomValue = random.nextInt(999999);
        this.setName("Mateusz" + randomValue);
        this.setSurname("Janus" + randomValue);
    }
}
