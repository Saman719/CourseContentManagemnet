package com.example.demo.controller;

import com.example.demo.model.CourseContent;
import com.example.demo.model.User;
import com.example.demo.service.FileService;
import com.example.demo.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;
    @Autowired
    FileService fileService;

    @PostMapping("/course-content/save")
    public ModelAndView uploadCourseContent(@RequestParam("file") MultipartFile file, @RequestParam("description") String description , @RequestParam("visible") String visible) {
        CourseContent courseContent = new CourseContent();
        String url = fileService.uploadFile(file);
        String name = file.getOriginalFilename();
        courseContent.setName(name);
        courseContent.setDescription(description);
        courseContent.setUrl(url);
        courseContent.setGuestVisible(visible.equals("yes") ? 1 : 0);
        courseContentService.addCourseContent(courseContent);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homepage");
        return modelAndView;
    }

    @GetMapping("/course-content/download/{name}")
    public void downloadCourseContent(@PathVariable("name") String name) {
        CourseContent courseContent = courseContentService.getCourseContentByName(name);
        fileService.downloadFile(courseContent.getUrl());
    }


    @GetMapping("/course-content/all")
    public Iterable<CourseContent> showCourseContents(){
        return courseContentService.getAllCourseContents();
    }

    @GetMapping("/course-content/{name}")
    public CourseContent getCourseContentByEmail(@PathVariable("name") String name) {
        return courseContentService.getCourseContentByName(name);
    }

    @PutMapping("/course-content/edit")
    public void updateUser(@RequestBody CourseContent courseContent) {
        courseContentService.updateCourseContent(courseContent);
    }

    @DeleteMapping("/course-content/delete")
    public void deleteCourseContent(@RequestBody CourseContent courseContent){
        courseContentService.deleteCourseContent(courseContent);
        fileService.deleteFile(courseContent.getUrl());
    }

    @PostMapping("/test")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        fileService.uploadFile(file);
        return "Uploaded!";
    }

    @GetMapping("/test")
    public String printHello(){
        System.out.println("Get Method Ran");
        return "Received";
    }


}
