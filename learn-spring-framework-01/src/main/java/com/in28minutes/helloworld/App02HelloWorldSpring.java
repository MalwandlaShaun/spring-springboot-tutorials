package com.in28minutes.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args){
        //1: Launch a spring Context
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){

            //2: Configure the things that we want Spring to Manage -
            // HelloWorldConfiguration - @Configuration
            // name - @Bean

            //3: Retrieving Beans managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Person.class));
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean("person5Qualifier"));


            //System.out.println (answering Q3 and Qualifier answers Q4)
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }

    }
}
