package ru.nevars.example.service;

import org.springframework.context.ApplicationEvent;
import ru.nevars.example.entity.Person;

public class PersonEvent extends ApplicationEvent {

    public PersonEvent(Object source) {
        super(source);
    }

    public Person getPerson() {
        return (Person) getSource();
    }
}
