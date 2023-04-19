package com.mjanus.springbatch;

import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class ProductProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person item) throws Exception {
        return new Person(item.getName(), item.getSurname(), String.valueOf(
                LocalDate.now().getYear() - Integer.parseInt(item.getBirthday().substring(6,10))));
    }
}