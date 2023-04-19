package com.mjanus.jpa;

import com.mjanus.jpa.model.Person;
import com.mjanus.jpa.model.SubTask;
import com.mjanus.jpa.model.Task;
import jakarta.persistence.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class Jpa3ApplicationTests {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Test
    void contextLoads() {
        EntityManager em = emf.createEntityManager();
        List<Long> longList = insertExampleData();
        TypedQuery<Task> query = em.createQuery("from Task where id in (" + TaskIds(longList) + ")", Task.class);

        EntityGraph<Task> eg = em.createEntityGraph(Task.class);
        eg.addSubgraph("persons").addAttributeNodes("subTask");
        eg.addAttributeNodes("subTasks");

        query.setHint("javax.persistence.fetchgraph", eg);

        List<Task> tasks = query.getResultList();

        for (Task task : tasks) {
            System.out.println(task);
            System.out.println(task.getSubTasks());

            for (Person person : task.getPersons()) {
                System.out.println(person);
                System.out.println(person.getSubTask());
            }
        }
    }

    private List<Long> insertExampleData() {
        Person person1 = generatePerson();
        Person person2 = generatePerson();
        Person person3 = generatePerson();
        Person person4 = generatePerson();
        Task task1 = generateTask();
        Task task2 = generateTask();
        Task task3 = generateTask();
        Task task4 = generateTask();
        SubTask subTask1 = generateSubTask();
        SubTask subTask2 = generateSubTask();
        SubTask subTask3 = generateSubTask();
        SubTask subTask4 = generateSubTask();
        subTask1.setPersons(Set.of(person1, person2));
        subTask2.setPersons(Set.of(person1, person2));
        subTask3.setPersons(Set.of(person3, person4));
        subTask4.setPersons(Set.of(person3, person4));
        task1.setSubTasks(Set.of(subTask1,subTask2));
        task2.setSubTasks(Set.of(subTask1,subTask2));
        task3.setSubTasks(Set.of(subTask3,subTask4));
        task4.setSubTasks(Set.of(subTask3,subTask4));
        task1.setPersons(Set.of(person1, person2));
        task2.setPersons(Set.of(person1, person2));
        task3.setPersons(Set.of(person3, person4));
        task4.setPersons(Set.of(person3, person4));
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(task1);
        em.persist(task2);
        em.persist(task3);
        em.persist(task4);
        em.persist(subTask1);
        em.persist(subTask2);
        em.persist(subTask3);
        em.persist(subTask4);
        em.persist(person1);
        em.persist(person2);
        em.persist(person3);
        em.persist(person4);
        em.flush();
        em.getTransaction().commit();
        em.close();
        return List.of(task1.getId(), task2.getId());
    }

    private Task generateTask() {
        Task task = new Task();
        task.generateRandomTask();
        return task;
    }

    private SubTask generateSubTask() {
        SubTask subTask = new SubTask();
        subTask.generateRandomSubTask();
        return subTask;
    }

    private Person generatePerson() {
        Person person = new Person();
        person.generateRandomPerson();
        return person;
    }

    private String TaskIds(List<Long> invoiceIds) {
        return invoiceIds.stream()
                .map(n -> "" + n)
                .collect(Collectors.joining(","));
    }
}
