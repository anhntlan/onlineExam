package com.example.onlineExam.service.impl;

import com.example.onlineExam.model.Exam;
import com.example.onlineExam.model.UserAnswer;
import com.example.onlineExam.repository.ExamRepository;
import com.example.onlineExam.repository.UserRepository;
import com.example.onlineExam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamRepository examRepository;


    @Override
    public Optional<Exam> getExamByName(String name) {
        return examRepository.findByName(name);
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public boolean create(Exam exam) {
        try {
            examRepository.save(exam);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String deleteExam(Integer id) {
        examRepository.deleteById(id);
        return "Deleted Exam";
    }

    @Override
    public boolean updateExamById(int id, Exam exam) {
        Optional<Exam> existingExam = examRepository.findById(id);
        if (existingExam.isPresent()) {
            Exam exist = existingExam.get();
            exist.setName(exam.getName());
            exist.setDescription(exam.getDescription());
            exist.setType(exam.getType());
            exist.setStatus(exam.getStatus());
            exist.setDuration(exam.getDuration());

            examRepository.save(exist);
            return true;
        }
        return false;    }

    @Override
    public Optional<Exam> getExamById(Integer id) {
        return examRepository.findById(id);
    }


}
