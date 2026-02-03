package com.example.Student_Management.service;

import com.example.Student_Management.dto.StudentRequestDto;
import com.example.Student_Management.dto.StudentResponseDto;
import com.example.Student_Management.exception.StudentNotFoundException;
import com.example.Student_Management.model.StudentModel;
import com.example.Student_Management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //create
//    public StudentModel addStudent(StudentModel student) {
//        return repository.save(student);
//
//    }
    //response-record
    //request-class
    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student=new StudentModel();
        //database
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        StudentModel saved=repository.save(student);
        return new StudentResponseDto(
                //response
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }

//    public List<StudentModel> getStudents() {
//        return repository.findAll();
//    }
//    public StudentModel updateStudent(String id,StudentModel student) {
//        StudentModel existingStudent = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("no student found"));
//        existingStudent.setAge(student.getAge());
//        existingStudent.setName(student.getName());
//        existingStudent.setEmail(student.getEmail());
//        return repository.save(existingStudent);
//    }
    public List<StudentResponseDto> getAllStudents(){
        return repository.findAll()
        .stream()
        .map( s->new StudentResponseDto(
                s.getId(),
                s.getName(),
                s.getAge(),
                s.getEmail()
        )).toList();
    }
    public void deleteStudent(String id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException("Student not found");
        }
        repository.deleteById(id);
    }
    public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {

        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // update fields
        existingStudent.setName(dto.getName());
        existingStudent.setAge(dto.getAge());
        existingStudent.setEmail(dto.getEmail());

        StudentModel updated = repository.save(existingStudent);

        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }

}