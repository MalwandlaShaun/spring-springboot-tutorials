package com.in28minutes.com.in28minutes.learn_spring_framework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {

    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready");
    }

    @PostConstruct
    public void initialize() {
        this.someDependency.getReady();
    }


    @PreDestroy
    public void preDestroy() {
        System.out.println("cleanup!!!");
    }


}

@Component
class SomeDependency{
    public void getReady(){
        System.out.println("Initializing .... SomeDependency");
    }
}

@Configuration
@ComponentScan
public class PostConstructPreDestroyLauncherApplication {

    public static void main(String[] args){

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PostConstructPreDestroyLauncherApplication.class)){

//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            context.getBean(SomeClass.class);
        }

    }
}
