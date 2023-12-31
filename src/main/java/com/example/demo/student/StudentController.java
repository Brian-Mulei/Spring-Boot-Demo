package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
            return  studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }


    @DeleteMapping(path ="{studentID}")
    public  void  deleteStudent(@PathVariable("studentID")Long studentId){

        studentService.deleteStudent(studentId);

    }

    @PutMapping(path="{studentID}")
    public void updateStudent(
            @PathVariable("studentID")Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email


    ){
        studentService.updateStudent(studentId,name,email);
    }


}
