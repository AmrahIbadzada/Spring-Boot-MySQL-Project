package com.example.student_ms.repository;
import com.example.student_ms.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

      Optional<StudentEntity> findByName(String name);
}
