package com.task;

import com.task.model.User;
import com.task.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CustomQueryTest {

    @Autowired
    UserRepository repo;

    @Test
    void testFindByName() {
        User user = new User();
        user.setId(3L);
        user.setName("QueryUser");
        repo.save(user);

        List<User> users = repo.findByName("QueryUser");
        assertFalse(users.isEmpty());
    }
}