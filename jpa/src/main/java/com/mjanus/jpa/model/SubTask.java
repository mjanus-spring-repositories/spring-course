package com.mjanus.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    @OneToMany(targetEntity = Person.class, mappedBy = "subTask")
    private Set<Person> persons = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public void generateRandomSubTask() {
        Random random = new Random();
        int randomValue = random.nextInt(999999);
        this.setName("JPA and Hibernate task" + randomValue);
        this.setStatus("ACTIVE");
    }
}
