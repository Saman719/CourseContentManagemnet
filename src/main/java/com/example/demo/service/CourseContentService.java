package com.example.demo.service;

import com.example.demo.model.CourseContent;
import com.example.demo.repository.CourseContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseContentService {

    @Autowired
    private CourseContentRepository courseContentRepository;

    public void addCourseContent(CourseContent courseContent){
        courseContentRepository.save(courseContent);
    }

    public Iterable<CourseContent> getAllCourseContents() {
        return courseContentRepository.findAll();
    }

    public void deleteCourseContent(CourseContent courseContent){
        courseContentRepository.delete(courseContent);
    }

    public CourseContent getCourseContentByName(String name) {
        return courseContentRepository.findByName(name);
    }

    public void updateCourseContent(CourseContent courseContent) {
        courseContentRepository.save(courseContent);
    }

}
