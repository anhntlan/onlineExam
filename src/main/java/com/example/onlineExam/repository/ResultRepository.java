package com.example.onlineExam.repository;

import com.example.onlineExam.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Integer> {
    List<Result> findByExamId(int examId);
    List<Result> findByUserId(int userId);
    List<Result> findByUserIdAndExamId(int userId, int examId);
    @Query("SELECT AVG(r.score) FROM Result r WHERE r.examId = ?1")
    Double findAverageScoreByExamId(int examId);
}
