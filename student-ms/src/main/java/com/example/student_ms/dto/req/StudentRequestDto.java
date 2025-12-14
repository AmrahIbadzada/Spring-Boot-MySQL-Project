package com.example.student_ms.dto.req;

public record StudentRequestDto(String name,
                                String surname,
                                String email,
                                String phone,
                                String postcode) {
}
