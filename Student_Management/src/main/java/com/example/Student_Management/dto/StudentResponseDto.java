package com.example.Student_Management.dto;

import org.springframework.data.annotation.Id;

public record StudentResponseDto(
        String id,
        String name,
        int age,
        String email
) {

}
