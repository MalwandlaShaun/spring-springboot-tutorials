package com.in28minutes.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Eliminate verbosity in creating java Beans
//Public accessor methods, constructor,
//equals, hashcode and toString are created.
//Released in JDH 16.

record Person(String firstName, int age, Address address) {}

record Address(String street, String city) {}

@Configuration
public class HelloWorldConfiguration {

//A component managed by the Spring IoC container - In a Spring Java configuration file,
// a Spring bean refers to a component that is managed by the Spring IoC (Inversion of Control) container.
// It is an instance of a class that is created, configured, and managed by the container.
    @Bean
    public String name(){
        return "Shaun";
    }
    @Bean
    public int age(){
        return 25;
    }

    @Bean
    public Person person(){
        return new Person("Malwandla", 25,new Address("216 fox st.", "Johannesburg") );
    }
    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3){
        return new Person(name, age, address3);
    }
    @Bean
    @Primary
    //No qualifying bean of type 'com.in28minutes.learn_spring_framework.Person'
    // available: expected single matching bean but found 5:
    // person,person2MethodCall,person3Parameters,person4Parameters,person5Parameters
    public Person person4Parameters(String name, int age, Address address){
        return new Person(name, age, address);
    }

    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address){
        return new Person(name, age, address);
    }

    @Bean(name= "address2")
    @Primary
    public Address address(){
        return new Address("33 knight", "Johannesburg");
    }


    @Bean(name= "address3")
    @Qualifier("address3qualifier")
    public Address address3(){
        return new Address("130 South st", "Centurion");
    }
}
