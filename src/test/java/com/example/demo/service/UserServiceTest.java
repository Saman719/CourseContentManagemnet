package com.example.demo.service;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserServiceTest {

    @Autowired
    UserService service;

    @Test
    void addGetDeleteUser() {
        User user = new User("Test","Test", "test1@gmail.com", "test" , "ROLE_STU");
        service.addUser(user);
        User user2 = service.getUserByEmail("test1@gmail.com");
        assertEquals("Test",user2.getName());
        assertEquals("Test",user2.getFamilyName());
        assertEquals("test1@gmail.com",user2.getEmail());
        assertEquals("test",user2.getPassword());
        assertEquals("ROLE_STU",user2.getRole());
        service.deleteUser(user2);
        User user3 = service.getUserByEmail("test1@gmail.com");
        assertNull(user3);
    }

    @Test
    void updateUser() {
        User user = new User("Test","Test", "test2@gmail.com", "test" , "ROLE_STU");
        service.addUser(user);
        User user2 = service.getUserByEmail("test2@gmail.com");
        user2.setName("TestChanged");
        service.updateUser(user2);
        user2 = service.getUserByEmail("test2@gmail.com");
        assertEquals("TestChanged",user2.getName());
        service.deleteUser(user2);
    }

    @Test
    void getAllUser() {
        List<User> users = new ArrayList<>();
        service.getAllUsers().forEach(users::add);
        assert(users.size()!=0);
    }
}