package com.eshop.user.controller;

import com.eshop.user.model.User;
import com.eshop.user.service.UserService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    UserService userService;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllUsers() throws Exception {
        User user = new User();
        user.setUserName("Ashutosh");
        user.setPassword("2345");
        User user2 = new User();
        user2.setUserName("Ashutosh2");
        user2.setPassword("23452");
        List<User> users = Arrays.asList(user, user2);
       // Optional<List<User>> usersOpt = Optional.of(users);
        Mockito.when(userService.fetchUserList()).thenReturn(users);
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].userName", Matchers.is("Ashutosh")));

    }

    @Test
    void getUserById() throws Exception {
        User user = new User();
        user.setUserName("Ashutosh");
        user.setPassword("2345");
        //List<User> users = Arrays.asList(user);
        Optional<User> userOpt = Optional.of(user);
        Mockito.when(userService.fetchUserById(1)).thenReturn(userOpt);
        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
               // .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$.userName", Matchers.is("Ashutosh")));
    }

  /*  @Test
    void saveUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUserById() {
    }*/
}