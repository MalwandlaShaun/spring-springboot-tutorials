package com.in28minutes.springboot.learn_jpa_and_hibernate;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
import com.in28minutes.springboot.learn_jpa_and_hibernate.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learn_jpa_and_hibernate.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learn_jpa_and_hibernate.springDataJpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

/*    @Autowired
    private CourseJdbcRepository repository;
    */
//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"Java Spring Boot", "Spring Boot"));
        repository.save(new Course(2,"Learn AWS springDatajpa", "in28minutes"));
        repository.save(new Course(3,"Learn Devops springDatajpa", "in28minutes"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findByAuthor("in28minutes"));
        System.out.println(repository.findByName("Learn AWS springDatajpa"));
    }
}
