package ru.nevars.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nevars.example.entity.UuidEntity;

import java.util.UUID;


public interface UuidRepository extends JpaRepository<UuidEntity, UUID> {
}
