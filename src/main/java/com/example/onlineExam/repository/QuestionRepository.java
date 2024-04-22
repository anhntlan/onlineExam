package com.example.onlineExam.repository;

import com.example.onlineExam.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findAllByExamId(int exam_id);
}
