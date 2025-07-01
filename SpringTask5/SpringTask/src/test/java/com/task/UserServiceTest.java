package com.task;

import com.task.model.User;
import com.task.repository.UserRepository;
import com.task.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = SpringTaskApplication.class)
public class UserServiceTest {

    @Test
    void testGetUserById() {
        UserRepository repo = mock(UserRepository.class);

        User user = new User();
        user.setId(1L);
        user.setName("Test");

        when(repo.findById(1L)).thenReturn(Optional.of(user));

        UserService service = new UserService(repo);
        assertEquals("Test", service.getUserById(1L).getName());
    }
}