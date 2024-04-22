package com.example.onlineExam.controller;

import com.example.onlineExam.model.Exam;
import com.example.onlineExam.model.Question;
import com.example.onlineExam.model.User;
import com.example.onlineExam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("")
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }
    @PostMapping("/add")

    public ResponseEntity<String> addQs(@RequestBody Question question) {
        boolean isCreated = questionService.create(question);
        if (isCreated) {
            return ResponseEntity.ok("Added a new question");
        } else {
            return ResponseEntity.badRequest().body("Failed to create new question");
        }
    }
    @GetMapping("/byid/{id}")
    public Optional<Question> getQsById(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }
    @GetMapping("/byExamId/{exam_id}")
    public List<Question> getQuestionByExamId(@PathVariable int exam_id) {
        return questionService.getQuestionsByExamId(exam_id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteQs(@PathVariable Integer id) {

        return questionService.deleteQuestion(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable int id, @RequestBody Question updatedQuestion) {
        boolean isUpdated = questionService.updateQuestionById(id, updatedQuestion);
        if (isUpdated) {
            return ResponseEntity.ok("Updated the question");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("can not find the question");
        }
    }




}
