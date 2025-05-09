package com.in28minutes.com.in28minutes.learn_spring_framework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass{

    Dependency1 dependency1;

    Dependency2 dependency2;

/*
    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Injection - setDependency1");
        this.dependency1 = dependency1;
    }

    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Injection - setDependency2");
        this.dependency2 = dependency2;
    }
*/

   // @Autowired
    public YourBusinessClass(Dependency2 dependency2, Dependency1 dependency1) {
        super();
        System.out.println("Constructor Injection - YourBusinessClass");
        this.dependency2 = dependency2;
        this.dependency1 = dependency1;
    }

    @Override
    public String toString() {
        return "using " + dependency1 + " and " + dependency2;
    }
}
@Component
class Dependency1{

}@Component
class Dependency2{

}


@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

    public static void main(String[] args){

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)){

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));
        }

    }
}
