package ru.nevars.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nevars.example.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
