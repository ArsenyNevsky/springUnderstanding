package ru.nevars.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.nevars.example.entity.Account;
import ru.nevars.example.entity.CreditAccount;
import ru.nevars.example.entity.DebitAccount;
import ru.nevars.example.repository.AccountRepository;

import java.util.Collection;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
public class AccountService implements ApplicationListener<PersonEvent> {

    private static final Logger logger = Logger.getLogger(AccountService.class.getName());

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
        Collection<Account> accounts = accountRepository.findAll();
        logger.info("The size of collection = " + accounts.size());
        return accounts;
    }

    @Override
    public void onApplicationEvent(PersonEvent personEvent) {
        logger.info("RECEIVED: " + personEvent);
    }
}
