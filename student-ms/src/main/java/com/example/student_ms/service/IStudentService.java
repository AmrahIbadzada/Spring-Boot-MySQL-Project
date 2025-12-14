package com.example.student_ms.service;

import com.example.student_ms.dto.SuccessDto;
import com.example.student_ms.dto.req.StudentRequestDto;
import com.example.student_ms.dto.res.StudentResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentService {

    ResponseEntity<SuccessDto<List<StudentResponseDto>>> allStudents();

    ResponseEntity<SuccessDto<StudentResponseDto>> createStudent(StudentRequestDto studentRequestDto);

    ResponseEntity<SuccessDto<StudentResponseDto>> updateStudent(Integer id, StudentRequestDto request);

    ResponseEntity<SuccessDto<StudentResponseDto>> findStudentById(Integer id);

    ResponseEntity<Void> deleteStudent(Integer id);

}
