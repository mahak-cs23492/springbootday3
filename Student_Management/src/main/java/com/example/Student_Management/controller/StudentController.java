package com.example.Student_Management.controller;
//record-immutable object
import com.example.Student_Management.dto.StudentRequestDto;
import com.example.Student_Management.dto.StudentResponseDto;
import com.example.Student_Management.model.StudentModel;
import com.example.Student_Management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins="*")
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
      @DeleteMapping("/delete/{id}")
      public String deleteStudent(@PathVariable String id) {
      service.deleteStudent(id);
      return "Student deleted successfully";
      }

    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(
            @PathVariable String id,
            @Valid @RequestBody StudentRequestDto student) {

        return service.updateStudent(id, student);
    }
    @PatchMapping("/patch/{id}")
    public StudentResponseDto patchStudent(@PathVariable String id,
                                           @RequestBody Map<String, Object> updates) {
        return service.patchStudent(id, updates);
    }
//    @PutMapping("/update/{id}")
//    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student) {
//        return service.updateStudent(id, student);
//    }
}