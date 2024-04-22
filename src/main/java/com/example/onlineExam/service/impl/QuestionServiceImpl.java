package com.example.onlineExam.service.impl;


import com.example.onlineExam.model.Question;
import com.example.onlineExam.repository.QuestionRepository;
import com.example.onlineExam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
     QuestionRepository questionRepository;


    @Override
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public boolean create(Question question) {
        try {
            questionRepository.save(question);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Question> getQuestionById(int id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getQuestionsByExamId(int exam_id) {
        return questionRepository.findAllByExamId(exam_id);
    }

    @Override
    public String deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
        return "Deleted a Question";
    }



    @Override
    public boolean updateQuestionById(int id, Question question) {
        Optional<Question> existingQuestionOptional = questionRepository.findById(id);
        if (existingQuestionOptional.isPresent()) {
            Question exist = existingQuestionOptional.get();
            exist.setText(question.getText());
            exist.setAnswerA(question.getAnswerA());
            exist.setAnswerB(question.getAnswerB());
            exist.setAnswerC(question.getAnswerC());
            exist.setAnswerD(question.getAnswerD());
            exist.setCorrectAnswer(question.getCorrectAnswer());
            exist.setExamId(question.getExamId());

            questionRepository.save(exist);
            return true;
        }
        return false;    }


}
