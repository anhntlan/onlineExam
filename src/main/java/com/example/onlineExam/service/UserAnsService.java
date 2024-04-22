package com.example.onlineExam.service;

import com.example.onlineExam.model.Question;
import com.example.onlineExam.model.UserAnswer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserAnsService {
    public List<UserAnswer> getAllUserAnswers();
    public boolean create(UserAnswer userAnswer);
    public Optional<UserAnswer> geUserAnsById(int id);
    public List<UserAnswer> getUserAnswersByUserId(int id);
    public List<UserAnswer> getUserAnswersByExamId(int examId);
    public List<UserAnswer> getUserAnswersByQuestionId(int questionId);
    public List<UserAnswer> getUserAnswersByUserIdAndExamId(int userId, int examId);
    public  boolean updateUserAnswer(int id, UserAnswer userAnswer);
    public boolean deleteUserAnswer(int id);

}
