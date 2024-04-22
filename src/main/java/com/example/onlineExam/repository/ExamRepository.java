package com.example.onlineExam.repository;

import com.example.onlineExam.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
    Optional<Exam> findByName(String username);
    List<Exam> findByStatus(String status);


}
