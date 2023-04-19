package com.mjanus.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    @OneToMany(targetEntity = Person.class, mappedBy = "task")
    private Set<Person> persons = new HashSet<>();
    @OneToMany(targetEntity = SubTask.class, mappedBy = "task")
    private Set<SubTask> subTasks = new HashSet<>();

    public void generateRandomTask() {
        Random random = new Random();
        int randomValue = random.nextInt(999999);
        this.setName("JPA and Hibernate task" + randomValue);
        this.setStatus("ACTIVE");
    }
}
