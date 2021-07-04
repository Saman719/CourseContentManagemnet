package com.example.demo.repository;

import com.example.demo.model.CourseContent;
import org.springframework.data.repository.CrudRepository;

public interface CourseContentRepository extends CrudRepository<CourseContent, Long> {
    CourseContent findByName(String name);
}
