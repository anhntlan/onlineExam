package com.example.onlineExam.repository;

import com.example.onlineExam.model.Submit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmitRepository  extends JpaRepository<Submit, Integer> {
    List<Submit> findByUserId(int userId);
    List<Submit> findByExamId(int examId);
    Submit findByUserIdAndExamId(int userId, int examId);
    int countByExamId(int examId);
    int countByUserId(int userId);
    int countDistinctUserIdByExamId(int examId);

}
