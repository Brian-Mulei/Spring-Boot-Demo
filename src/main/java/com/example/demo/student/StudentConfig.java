package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {


    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
     return  args ->{

     }   ;
    }
}
