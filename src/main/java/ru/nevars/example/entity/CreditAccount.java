package ru.nevars.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "CREDITACCOUNT")
public class CreditAccount extends Account {

    @Column(name = "credit_limit")
    protected int creditLimit;

    protected boolean closed;
}
