package com.in28minutes.learn_spring_boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public  List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1, "Learn spring", "in28minutes"),
                new Course(1, "Learn spring", "in28minutes")
        );
    }
}
