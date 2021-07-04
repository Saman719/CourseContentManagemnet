package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyProgramController {


    @GetMapping("/")
    public String homePage(){
        return "homepage";
    }

    @GetMapping("/student")
    public String studentPage(){
        return "student";
    }

    @GetMapping("/prof")
    public String professorPage(){
        return "prof";
    }

    @GetMapping("/user/register")
    public String showUserRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @GetMapping("/user/edit")
    public String showUserEditForm() {
        return "edit_user";
    }

    @GetMapping("/user/delete")
    public String showUserDeleteForm() {
        return "delete_user";
    }

    @GetMapping("/course-content/save")
    public String showCourseContentAddForm() {
        return "course-content-upload";
    }

    @GetMapping("/course-content")
    public String showAllCourseContentForm() {
        return "course-content-list";
    }

    @GetMapping("/course-content/delete")
    public String showDeleteCourseContentForm() {
        return "delete-course-content";
    }

    @GetMapping("/course-content/edit")
    public String showEditCourseContentForm() {
        return "edit-course-content";
    }

    @GetMapping("/prof/user")
    public String showProfUserForm() {
        return "prof-user";
    }

    @GetMapping("/prof/course-content")
    public String showProfCourseContentForm() {
        return "prof-course-content";
    }
}
