package com.example.student_ms.dto.res;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentResponseDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String phone;
}
