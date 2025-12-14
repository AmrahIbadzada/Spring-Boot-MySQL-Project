package com.example.student_ms.service.impl;

import com.example.student_ms.dto.SuccessDto;
import com.example.student_ms.dto.req.StudentRequestDto;
import com.example.student_ms.dto.res.StudentResponseDto;
import com.example.student_ms.entity.StudentEntity;
import com.example.student_ms.enums.SuccessStatus;
import com.example.student_ms.repository.StudentRepository;
import com.example.student_ms.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<SuccessDto<List<StudentResponseDto>>> allStudents() {
        List<StudentEntity> entities = studentRepository.findAll();

        List<StudentResponseDto> dtos = entities.stream()
                .map(entity -> StudentResponseDto.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .surname(entity.getSurname())
                        .email(entity.getEmail())
                        .phone(entity.getPhone())
                        .build())
                .collect(Collectors.toList());

        SuccessDto<List<StudentResponseDto>> successDto =
                new SuccessDto<>(SuccessStatus.SUCCESS.name(), dtos);

        return ResponseEntity.ok(successDto);

    }

    @Override
    public ResponseEntity<SuccessDto<StudentResponseDto>> createStudent(StudentRequestDto request) {

        StudentEntity entity =  StudentEntity.builder()
                .name(request.name())
                .surname(request.surname())
                .email(request.email())
                .phone(request.phone())
                .postcode(request.postcode())
                .build();

        StudentEntity saved = studentRepository.save(entity);

        StudentResponseDto dto = StudentResponseDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .surname(saved.getSurname())
                .email(saved.getEmail())
                .phone(saved.getPhone())
                .build();

        SuccessDto<StudentResponseDto> successDto =
                new SuccessDto<>(SuccessStatus.CREATED.name(), dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(successDto);
    }

    @Override
    public ResponseEntity<SuccessDto<StudentResponseDto>> updateStudent(Integer id, StudentRequestDto request) {
        StudentEntity entity = studentRepository.findById(id)
                .orElse(null);

        if (entity == null) {
            return ResponseEntity.notFound().build();
        }

        entity.setName(request.name());
        entity.setSurname(request.surname());
        entity.setEmail(request.email());
        entity.setPhone(request.phone());
        entity.setPostcode(request.postcode());

        StudentEntity updated = studentRepository.save(entity);

        StudentResponseDto dto = StudentResponseDto.builder()
                .id(updated.getId())
                .name(updated.getName())
                .surname(updated.getSurname())
                .email(updated.getEmail())
                .phone(updated.getPhone())
                .build();

        SuccessDto<StudentResponseDto> successDto =
                new SuccessDto<>(SuccessStatus.UPDATED.name(), dto);

        return ResponseEntity.ok(successDto);
    }

    @Override
    public ResponseEntity <SuccessDto<StudentResponseDto>> findStudentById(Integer id) {
        StudentEntity entity = studentRepository.findById(id)
                .orElse(null);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }

        StudentResponseDto dto = StudentResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .build();

        SuccessDto<StudentResponseDto> successDto =
                new SuccessDto<>(SuccessStatus.SUCCESS.name(), dto);

        return ResponseEntity.ok(successDto);
    }

    @Override
    public ResponseEntity<Void> deleteStudent(Integer id) {

        if (!studentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        studentRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
