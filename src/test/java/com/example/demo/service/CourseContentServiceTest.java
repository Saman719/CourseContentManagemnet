package com.example.demo.service;

import com.example.demo.model.CourseContent;
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
class CourseContentServiceTest {

    @Autowired
    CourseContentService service;

    @Test
    void addGetDeleteCourseContent() {
        CourseContent courseContent = new CourseContent("test-name","test","test");
        service.addCourseContent(courseContent);
        CourseContent courseContent2 = service.getCourseContentByName("test-name");
        assertEquals("test-name",courseContent2.getName());
        assertEquals("test",courseContent2.getDescription());
        assertEquals("test",courseContent2.getDescription());
        service.deleteCourseContent(courseContent2);
        CourseContent courseContent3 = service.getCourseContentByName("test-name");
        assertNull(courseContent3);
    }

    @Test
    void getAllCourseContents() {
        List<CourseContent> courseContents = new ArrayList<>();
        service.getAllCourseContents().forEach(courseContents::add);
        assert(courseContents.size()!=0);
    }

    @Test
    void updateCourseContent() {
        CourseContent courseContent = new CourseContent("test-name","test","test");
        service.addCourseContent(courseContent);
        CourseContent courseContent2 = service.getCourseContentByName("test-name");
        courseContent2.setDescription("test-changed");
        service.updateCourseContent(courseContent2);
        courseContent2 = service.getCourseContentByName("test-name");
        assertEquals("test-changed",courseContent2.getDescription());
        service.deleteCourseContent(courseContent2);
    }
}