package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private  final  StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> studentByEmail=
        studentRepository.findStudentsByEmail(student.getEmail());


        if(studentByEmail.isPresent()){
            throw  new IllegalStateException("EMAIL ALREADY TAKEN!!!");
        }else{
            studentRepository.save(student);
        }

    }

    public void deleteStudent(Long id) {
        boolean exists =studentRepository.existsById(id);

        if(!exists){
            throw new IllegalStateException(
              "Student with that id does not exists"
            );
        }
        else {
            studentRepository.deleteById(id);
        }
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "Student with that id does not exists"

        ));
    if(name!=null && name.length() >3){
        student.setName(name);
    }

        if(email!=null && email.length() >8){
            student.setEmail(email);
        }
    }
}
