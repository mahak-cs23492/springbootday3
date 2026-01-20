package com.example.Student_Management.service;

import com.example.Student_Management.model.StudentModel;
import com.example.Student_Management.repository.StudentRepository;
import org.springframework.stereotype.Service;
@Service
public class StudentService {
    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //create
    public StudentModel addStudent(StudentModel student){

        return repository.save(student);
    }

}
