package com.example.Student_Management.controller;

import com.example.Student_Management.dto.StudentRequestDto;
import com.example.Student_Management.dto.StudentResponseDto;
import com.example.Student_Management.model.StudentModel;
import com.example.Student_Management.service.StudentService;
import jakarta.validation.Valid;
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
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }
    @GetMapping("/students")
    public List<StudentResponseDto> getStudents(){
        return service.getAllStudents();
    }

//    @GetMapping("/students")
//    public List<StudentModel> getStudents(){
//        return service.getStudents();
//    }
//    @DeleteMapping("/delete/{id}")
//    public String deleteStudent(@PathVariable String id) {
//        service.deleteStudent(id);
//        return "Student deleted successfully";
//    }
      @DeleteMapping("/{id}")
      public String deleteStudent(@PathVariable String id) {
      service.deleteStudent(id);
      return "Student deleted successfully";
      }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(
            @PathVariable String id,
            @Valid @RequestBody StudentRequestDto student) {

        return service.updateStudent(id, student);
    }
//    @PutMapping("/update/{id}")
//    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student) {
//        return service.updateStudent(id, student);
//    }
}