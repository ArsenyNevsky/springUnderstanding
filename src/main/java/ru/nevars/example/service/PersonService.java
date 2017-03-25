package ru.nevars.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nevars.example.entity.Person;
import ru.nevars.example.entity.Phone;
import ru.nevars.example.repository.PersonRepository;

@RestController
@RequestMapping(value = "/",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/person", method = RequestMethod.GET, params = {"id"})
    public Person getPerson(@RequestParam Integer id) {
        return personRepository.findOne(id);
    }

    @RequestMapping(value = "/person", method = RequestMethod.DELETE, params = {"id"})
    public void removePerson(@RequestParam Integer id) {
        personRepository.delete(id);
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST, params = {"id"})
    public void save(@RequestParam Integer id) {
        Person newPerson = new Person();
        newPerson.setFirstname("CreatedPerson");

        Phone phone1 = new Phone();
        phone1.setNumber("100001");
        phone1.setPerson(newPerson);

        Phone phone2 = new Phone();
        phone2.setNumber("100002");
        phone2.setPerson(newPerson);

        newPerson.getPhones().add(phone1);
        newPerson.getPhones().add(phone2);

        personRepository.save(newPerson);
    }
}
