package com.example.onlineExam.service;

import com.example.onlineExam.model.Exam;
import com.example.onlineExam.model.UserAnswer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ExamService {
    public Optional<Exam> getExamByName(String name);
    public List<Exam> getAllExams();
    public boolean create(Exam exam);
    public String deleteExam(Integer id);
    public boolean updateExamById(int id, Exam exam);
    public Optional<Exam> getExamById(Integer id);

}
