package com.mjanus.bytecode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.*;

@Slf4j
@SpringBootApplication
public class ByteCodeApplication {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        log.info("Randomly generated indexNumber is " + getIndexNumber(createStudent(args)));
    }

    private static Student createStudent(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SpringApplication.run(ByteCodeApplication.class, args);
        Class<Student> descriptor = Student.class;
        Constructor<Student> constructor = descriptor.getConstructor(String.class);
        return constructor.newInstance(Student.initializeIndexNumber());
    }

    private static String getIndexNumber(Student student) throws NoSuchFieldException, IllegalAccessException {
        Field signatureField = Student.class.getDeclaredField("indexNumber");
        signatureField.setAccessible(true);
        return (String)signatureField.get(student);
    }
}
