package com.task;

import com.task.model.User;
import com.task.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
public class IntegrationTest {

    @Autowired
    UserRepository repo;

    @Test
    void testFullFlow() {
        User user = new User();
        user.setId(1L);
        user.setName("Integration User");

        repo.save(user);

        User found = repo.findById(1L).orElse(null);
        assertNotNull(found);
        assertEquals("Integration User", found.getName());
    }
}