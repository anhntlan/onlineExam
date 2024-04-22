package com.example.onlineExam.service;

import com.example.onlineExam.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ResultService {
    public List<Result> getResults();
    public boolean create(Result result);
    public Optional<Result> getResultById(int id);
    public List<Result> getResultsByExamId(int examId);
    public List<Result> getResultsByUserId(int userId);
    public boolean update(int id, Result result);
    public boolean delete(int id);
    public List<Result> getResultsByUserIdAndExamId(int userId, int examId);
    public     Double getAverageScoreByExamId(int examId);

}
