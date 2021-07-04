package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    @ResponseBody
    public ModelAndView addUser(User user){
        if(user.getRole() == null) {
            user.setRole("ROLE_STU");
        }
        userService.addUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homepage");
        return modelAndView;
    }


    @GetMapping("/user")
    public List<User> showUsers(){
        List<User> actualList = new ArrayList<>();
        userService.getAllUsers().forEach(actualList::add);
        return actualList;
    }

    @GetMapping("/user/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/user/edit")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/user/delete")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

    @GetMapping("/user/profile")
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User user = userService.getUserByEmail(email);
        if(user == null) {
            user = new User();
        }
        return user;
    }
}
