package ru.nevars.example.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nevars.example.entity.Person;
import ru.nevars.example.entity.Phone;
import ru.nevars.example.repository.PersonRepository;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
public class PersonService implements ApplicationContextAware {

    @Autowired
    private PersonRepository personRepository;
    private static final Logger logger = Logger.getLogger(PersonService.class.getName());
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/person", method = RequestMethod.GET, params = {"id"})
    public Person getPerson(@RequestParam Integer id) {
        return personRepository.findOne(id);
    }

    @RequestMapping(value = "/person", method = RequestMethod.DELETE, params = {"id"})
    public void removePerson(@RequestParam Integer id) {
        personRepository.delete(id);
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public void save(@RequestParam Person newPerson) {

        Phone phone1 = new Phone();
        phone1.setNumber("100001");
        phone1.setPerson(newPerson);

        Phone phone2 = new Phone();
        phone2.setNumber("100002");
        phone2.setPerson(newPerson);

        newPerson.getPhones().add(phone1);
        newPerson.getPhones().add(phone2);

        newPerson = personRepository.save(newPerson);
        logger.info("SEND: " + newPerson);
        applicationContext.publishEvent(new PersonEvent(newPerson));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
