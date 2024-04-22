package com.example.onlineExam.repository;

import com.example.onlineExam.model.User;
import com.example.onlineExam.model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserAnsRepository extends JpaRepository<UserAnswer,Integer> {

    List<UserAnswer> findByUserId(int id);
    List<UserAnswer> findByExamId(int examId);
    List<UserAnswer> findByQuestionId(int questionId);
    List<UserAnswer> findByUserIdAndExamId(int userId, int examId);

}
