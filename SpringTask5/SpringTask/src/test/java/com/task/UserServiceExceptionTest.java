package com.task;

import com.task.repository.UserRepository;
import com.task.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = SpringTaskApplication.class)
public class UserServiceExceptionTest {

    @Test
    public void testMissingUser() {
        // Mock repository
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(1L)).thenReturn(Optional.empty());

        // Inject mock into service
        UserService service = new UserService(mockRepo);

        // Verify exception is thrown
        assertThrows(RuntimeException.class, () -> service.getUserById(1L));
    }
}