package com.example.onlineExam.service.impl;


import com.example.onlineExam.model.UserAnswer;
import com.example.onlineExam.repository.UserAnsRepository;
import com.example.onlineExam.service.UserAnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserAnsServiceImpl implements UserAnsService {
    @Autowired
    UserAnsRepository userAnsRepository;

    @Override
    public boolean create(UserAnswer userAnswer) {
        try {
            userAnsRepository.save(userAnswer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<UserAnswer> geUserAnsById(int id) {
        return userAnsRepository.findById(id);
    }

    @Override
    public List<UserAnswer> getUserAnswersByUserId(int id) {
        return userAnsRepository.findByUserId(id);
    }

    @Override
    public List<UserAnswer> getUserAnswersByExamId(int examId) {
        return userAnsRepository.findByExamId(examId);
    }

    @Override
    public List<UserAnswer> getUserAnswersByQuestionId(int questionId) {
        return userAnsRepository.findByQuestionId(questionId);
    }

    @Override
    public List<UserAnswer> getUserAnswersByUserIdAndExamId(int userId, int examId) {
        return userAnsRepository.findByUserIdAndExamId(userId, examId);
    }

    @Override
    public boolean updateUserAnswer(int id, UserAnswer userAnswer) {
        Optional<UserAnswer> existingUserAnswer = userAnsRepository.findById(id);
        if (existingUserAnswer.isPresent()) {
            userAnswer.setSelectedAnswer(existingUserAnswer.get().getSelectedAnswer());
            userAnswer.setUserId(existingUserAnswer.get().getUserId());
            userAnswer.setExamId(existingUserAnswer.get().getExamId());
            userAnswer.setQuestionId(existingUserAnswer.get().getQuestionId());
            userAnsRepository.save(userAnswer);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteUserAnswer(int id) {
        Optional<UserAnswer> existingUserAnswer = userAnsRepository.findById(id);
        if (existingUserAnswer.isPresent()) {
            userAnsRepository.delete(existingUserAnswer.get());
            return true;
        } else {
            return false;
        }    }
}
