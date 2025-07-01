package com.task;

import com.task.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class GlobalExceptionHandlerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    void testExceptionHandling() throws Exception {
        when(userService.getUserById(100L)).thenThrow(new NoSuchElementException());

        mockMvc.perform(get("/users/100"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }
}
