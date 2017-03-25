package ru.nevars.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.nevars.example.entity.Account;
import ru.nevars.example.entity.CreditAccount;
import ru.nevars.example.entity.DebitAccount;
import ru.nevars.example.repository.AccountRepository;

import java.util.Collection;

@RestController
@RequestMapping(value = "/",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public void save() {
        CreditAccount credit1 = new CreditAccount();
        credit1.setCreditLimit(100);
        credit1.setBalance(1000);
        credit1.setOwner("Nevsky");
        credit1.setClosed(true);

        DebitAccount debit = new DebitAccount();
        debit.setBalance(200);
        debit.setOwner("Timofey");
        debit.setOverdraftFee(2);

        accountRepository.save(credit1);
        accountRepository.save(debit);
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public Collection<Account> getAccounts() {
        return accountRepository.findAll();
    }
}
