package com.example.Student_Management.controller;

import com.example.Student_Management.model.StudentModel;
import com.example.Student_Management.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {

        this.service = service;
    }
    //create function api
    @PostMapping("/add-student")
    public StudentModel addStudent(@RequestBody StudentModel student){
        return service.addStudent(student);
    }


    @GetMapping("/students")
    public List<StudentModel> getStudents(){
        return service.getStudents();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }


    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student) {
        return service.updateStudent(id, student);
    }
}