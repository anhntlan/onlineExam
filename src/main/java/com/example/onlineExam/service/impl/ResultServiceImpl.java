package com.example.onlineExam.service.impl;

import com.example.onlineExam.model.Result;
import com.example.onlineExam.repository.ResultRepository;
import com.example.onlineExam.service.ResultService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    ResultRepository resultRepository;

    @Override
    public List<Result> getResults() {
        return resultRepository.findAll();
    }

    @Override
    public boolean create(Result result) {
        try {
            resultRepository.save(result);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    }

    @Override
    public Optional<Result> getResultById(int id) {
        return resultRepository.findById(id);
    }

    @Override
    public List<Result> getResultsByExamId(int examId) {
        return resultRepository.findByExamId(examId);
    }

    @Override
    public List<Result> getResultsByUserId(int userId) {
        return resultRepository.findByUserId(userId);
    }

    @Override
    public boolean update(int id, Result result) {
        Optional<Result> existingResult = resultRepository.findById(id);
        if (existingResult.isPresent()) {
            result.setExamId(existingResult.get().getExamId());
            result.setUserId(existingResult.get().getUserId());
            result.setScore(existingResult.get().getScore());
            result.setStatus(existingResult.get().getStatus());
            resultRepository.save(result);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        Optional<Result> existingResult = resultRepository.findById(id);
        if (existingResult.isPresent()) {
            resultRepository.delete(existingResult.get());
            return true;
        } else {
            return false;
        }    }

    @Override
    public List<Result> getResultsByUserIdAndExamId(int userId, int examId) {
        return resultRepository.findByUserIdAndExamId(userId, examId);

    }

    @Override
    public Double getAverageScoreByExamId(int examId) {
        return resultRepository.findAverageScoreByExamId(examId);
    }
}
