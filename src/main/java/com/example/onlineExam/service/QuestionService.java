package com.example.onlineExam.service;

import com.example.onlineExam.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface QuestionService {
    public List<Question> getQuestions();
    public boolean create(Question question) ;
    public Optional<Question> getQuestionById(int id);
    public List<Question> getQuestionsByExamId(int exam_id);
    public String deleteQuestion(Integer id);
    public boolean updateQuestionById(int id, Question question);


}
