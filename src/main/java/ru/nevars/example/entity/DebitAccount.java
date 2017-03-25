package ru.nevars.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "DEBITACCOUNT")
public class DebitAccount extends Account {

    @Column(name = "overdraft_fee")
    protected int overdraftFee;
}
