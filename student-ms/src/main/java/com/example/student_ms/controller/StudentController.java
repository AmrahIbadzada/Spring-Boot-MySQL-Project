package com.example.student_ms.controller;

import com.example.student_ms.dto.SuccessDto;
import com.example.student_ms.dto.req.StudentRequestDto;
import com.example.student_ms.dto.res.StudentResponseDto;
import com.example.student_ms.repository.StudentRepository;
import com.example.student_ms.service.IStudentService;
import com.example.student_ms.service.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @GetMapping("/studentsdto")
    public ResponseEntity<SuccessDto<List<StudentResponseDto>>> allstudents() {

        return studentService.allStudents();
    }

    @PostMapping("/reponsedto")
    public ResponseEntity<SuccessDto<StudentResponseDto>> createStudent(@RequestBody StudentRequestDto request) {
        return studentService.createStudent(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessDto<StudentResponseDto>> updateStudent(
            @PathVariable Integer id,
            @RequestBody StudentRequestDto request) {

        return studentService.updateStudent(id, request);
    }

    @DeleteMapping(("/{id}"))
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {

        return studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessDto<StudentResponseDto>> findStudentById(
            @PathVariable Integer id ) {

        return studentService.findStudentById(id);
    }
}
