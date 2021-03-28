package com.helmes;


import com.helmes.dto.UserFormDto;
import com.helmes.dto.UserListDto;
import com.helmes.model.User;
import com.helmes.service.UserService;
import com.helmes.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
        List<UserListDto> expectedList = new ArrayList<>();
        UserListDto userListDto = new UserListDto();
        userListDto.setId(1L);
        userListDto.setName("test1");
        userListDto.setAgreeToTerm(Boolean.TRUE);

        UserListDto userListDto2 = new UserListDto();
        userListDto2.setId(2L);
        userListDto2.setName("test2");
        userListDto2.setAgreeToTerm(Boolean.TRUE);
        expectedList.add(userListDto);
        expectedList.add(userListDto2);

        when(userService.findAll()).thenReturn(expectedList);


        MockHttpServletResponse mvcResponse = mockMvc
                .perform(MockMvcRequestBuilders.get("/"))
                .andReturn().getResponse();

        assertTrue(mvcResponse.getContentAsString().contains("test1"));
        assertEquals("text/html;charset=UTF-8",mvcResponse.getContentType());
        assertEquals(200, mvcResponse.getStatus());
    }

    @Test
    void user_edit_test() throws Exception {
        UserFormDto userFormDto = new UserFormDto();
        userFormDto.setSectorIdList(Arrays.asList(1L,2L));
        userFormDto.setAgreeToTerm(Boolean.TRUE);
        userFormDto.setName("test1");


        when(userService.getUserDto(any())).thenReturn(userFormDto);

        MockHttpServletResponse mvcResponse = mockMvc
                .perform(MockMvcRequestBuilders.get("/edit/1"))
                .andReturn().getResponse();

        assertTrue(mvcResponse.getContentAsString().contains("test1"));
        assertEquals("text/html;charset=UTF-8",mvcResponse.getContentType());
        assertEquals(200, mvcResponse.getStatus());


    }

    @Test
    void user_post_test() throws Exception {
        UserFormDto userFormDto = new UserFormDto();
        userFormDto.setSectorIdList(Arrays.asList(1L,2L));
        userFormDto.setAgreeToTerm(Boolean.TRUE);
        userFormDto.setName("test");

        User user = new User();
        user.setId(1L);
        user.setName("test");

        when(userService.save(any())).thenReturn(user);
        MvcResult mvcResult = mockMvc.perform(post("/add")
                .contentType(Util.APPLICATION_JSON_UTF8)
                .content(Util.convertObjectToJsonBytes(userFormDto))
        ).andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());

    }
}