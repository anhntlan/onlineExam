package com.example.onlineExam.controller;

import com.example.onlineExam.model.Exam;
import com.example.onlineExam.model.Question;
import com.example.onlineExam.model.User;
import com.example.onlineExam.model.UserAnswer;
import com.example.onlineExam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("exam")
public class ExamController{
        @Autowired
        ExamService examService;

        @GetMapping("/byname/{name}")
        public Optional<Exam> getExamByName(@PathVariable String name) {
            return examService.getExamByName(name);
        }
        @GetMapping("/byid/{id}")
        public Optional<Exam> getExamById(@PathVariable Integer id) {
                return examService.getExamById(id);
        }
        @GetMapping("/byStatus/{status}")
        public List<Exam> getExamsByStatus(@PathVariable String status) {
                return examService.getExamsByStatus(status);
        }
        @PostMapping("/add")
//        public Exam addExam(@RequestBody Exam exam) {
//                return examService.create(exam);
//        }
        public ResponseEntity<String> createExam(@RequestBody Exam exam) {
                boolean isCreated = examService.create(exam);
                if (isCreated) {
                        return ResponseEntity.ok("Added a new Exam");
                } else {
                        return ResponseEntity.badRequest().body("Failed to create Exam");
                }
        }
        @GetMapping("")
        public List<Exam> getAllExams() {
                return examService.getAllExams();
        }
        @DeleteMapping("/delete/{id}")
        public String deleteExam(@PathVariable Integer id) {
                return examService.deleteExam(id);
        }
        @PutMapping("/update/{id}")
        public ResponseEntity<?> updateExam(@PathVariable int id, @RequestBody Exam exam) {
                boolean isUpdated = examService.updateExamById(id, exam);
                if (isUpdated) {
                        return ResponseEntity.ok("Updated the exam");
                } else {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("can not find the exam");
                }
        }





}
