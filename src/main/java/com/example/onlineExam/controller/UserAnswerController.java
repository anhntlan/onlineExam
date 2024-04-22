package com.example.onlineExam.controller;

import com.example.onlineExam.model.Question;
import com.example.onlineExam.model.UserAnswer;
import com.example.onlineExam.repository.UserAnsRepository;
import com.example.onlineExam.service.QuestionService;
import com.example.onlineExam.service.UserAnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("useranswer")
public class UserAnswerController {
    @Autowired
    UserAnsService userAnsService;

    @GetMapping("")
    public List<UserAnswer> getAllUserAnswers() {
        return userAnsService.getAllUserAnswers();
    }
    @PostMapping("/add")

    public ResponseEntity<String> createUserAnswer(@RequestBody UserAnswer userAnswer) {
        boolean isCreated = userAnsService.create(userAnswer);
        if (isCreated) {
            return ResponseEntity.ok("Added a new User answer");
        } else {
            return ResponseEntity.badRequest().body("Failed to create UserAnswer");
        }
    }
    @GetMapping("/byid/{id}")
    public Optional<UserAnswer> getUAById(@PathVariable int id) {
        return userAnsService.geUserAnsById(id);
    }
    @GetMapping("/byUser/{userId}")
    public ResponseEntity<?> getUserAnswersByUserId(@PathVariable int userId) {
        List<UserAnswer> userAnswers = userAnsService.getUserAnswersByUserId(userId);
        if (!userAnswers.isEmpty()) {
            return ResponseEntity.ok(userAnswers);
        } else {
            return ResponseEntity.badRequest().body("This user not exist or no answer exist! ");
        }
    }
    @GetMapping("/byExam/{examId}")
    public ResponseEntity<?> getUserAnswersByExamId(@PathVariable int examId) {
        List<UserAnswer> userAnswers = userAnsService.getUserAnswersByExamId(examId);
        if (!userAnswers.isEmpty()) {
            return ResponseEntity.ok(userAnswers);
        } else {
            return ResponseEntity.badRequest().body("This exam not exist or no answer exist  ");
        }
    }
    @GetMapping("/byQs/{questionId}")
    public ResponseEntity<?> getUserAnswersByQuestionId(@PathVariable int questionId) {
        List<UserAnswer> userAnswers = userAnsService.getUserAnswersByQuestionId(questionId);
        if (!userAnswers.isEmpty()) {
            return ResponseEntity.ok(userAnswers);
        } else {
            return ResponseEntity.badRequest().body("This question not exist or no answer exist  ");
        }
    }
    @GetMapping("/user/{userId}/exam/{examId}")
    public ResponseEntity<?> getUserAnswersByUserIdAndExamId(@PathVariable int userId, @PathVariable int examId) {
        List<UserAnswer> userAnswers = userAnsService.getUserAnswersByUserIdAndExamId(userId, examId);
        if (!userAnswers.isEmpty()) {
            return ResponseEntity.ok(userAnswers);
        } else {
            return ResponseEntity.badRequest().body("Không tìm thấy kết quả làm bài của userId: " + userId + " và examId: " + examId);
        }
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editUserAnswer(@PathVariable int id, @RequestBody UserAnswer userAnswer) {
        boolean isUpdated = userAnsService.updateUserAnswer(id, userAnswer);
        if (isUpdated) {
            return ResponseEntity.ok("User answer updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update user answer");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserAnswer(@PathVariable int id) {
        boolean isDeleted = userAnsService.deleteUserAnswer(id);
        if (isDeleted) {
            return ResponseEntity.ok("User answer deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete user answer");
        }
    }

}
