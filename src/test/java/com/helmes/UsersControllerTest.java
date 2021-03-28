package com.helmes;


import com.helmes.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void user_list_test() throws Exception {
        Assertions.assertTrue(Boolean.TRUE);
    }

    @Test
    void user_edit_test() throws Exception {
        Assertions.assertTrue(Boolean.TRUE);
    }

    @Test
    void user_post_test() throws Exception {
        Assertions.assertTrue(Boolean.TRUE);
    }
}