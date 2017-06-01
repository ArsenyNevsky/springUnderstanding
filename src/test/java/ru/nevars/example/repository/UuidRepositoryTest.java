package ru.nevars.example.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.nevars.example.entity.UuidEntity;

import static org.junit.Assert.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UuidRepositoryTest {

    @Autowired
    private UuidRepository repository;

    @Test
    public void save() throws Exception {
        UuidEntity entity = new UuidEntity();
        entity.setName("New entity");
        entity = repository.save(entity);

        assertTrue(true);
        System.out.println();
        System.out.println(repository.findAll());
        System.out.println();

        entity.setName("Update entity");
        entity = repository.save(entity);
        System.out.println();
        System.out.println(repository.findAll());
        System.out.println();
    }

}