package ru.nevars.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nevars.example.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
