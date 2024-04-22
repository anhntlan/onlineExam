
package com.example.onlineExam.controller;

import com.example.onlineExam.model.Question;
import com.example.onlineExam.model.Result;
import com.example.onlineExam.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("result")
public class ResultController {
    @Autowired
     ResultService resultService;

    @GetMapping("")
    public List<Result> getAllResult() {
        return resultService.getResults();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addResult(@RequestBody Result result) {
        boolean isCreated = resultService.create(result);
        if (isCreated) {
            return ResponseEntity.ok("Added a new result");
        } else {
            return ResponseEntity.badRequest().body("Failed to create new result");
        }
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<?> getResultById(@PathVariable int id) {
        Optional<Result> result = resultService.getResultById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.badRequest().body("The result with id " + id + " does not exist");
        }
    }

    @GetMapping("/byExamId/{examId}")
    public List<Result> getResultsByExamId(@PathVariable int examId) {
        return resultService.getResultsByExamId(examId);
    }
    @GetMapping("/byUserId/{userId}")
    public List<Result> getResultsByUserId(@PathVariable int userId) {
        return resultService.getResultsByUserId(userId);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editResult(@PathVariable int id, @RequestBody Result result) {
        boolean isUpdated = resultService.update(id, result);
        if (isUpdated) {
            return ResponseEntity.ok("Result updated successfully");
        } else {
            return ResponseEntity.badRequest().body("can not find result with id " + id);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable int id) {
        boolean isDeleted = resultService.delete(id);
        if (isDeleted) {
            return ResponseEntity.ok("Result deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("can not find result with id " +id);
        }
    }
    @GetMapping("/user/{userId}/exam/{examId}")
    public ResponseEntity<?> getResultsByUserIdAndExamId(@PathVariable int userId, @PathVariable int examId) {
        List<Result> results = resultService.getResultsByUserIdAndExamId(userId, examId);
        if (!results.isEmpty()) {
            return ResponseEntity.ok(results);
        } else {
            return ResponseEntity.badRequest().body("can not find the result for this IDs" );
        }
    }
    @GetMapping("/average/{examId}")
    public ResponseEntity<?> getAverageScoreByExamId(@PathVariable int examId) {
        Double averageScore = resultService.getAverageScoreByExamId(examId);
        if (averageScore != null) {
            return ResponseEntity.ok(averageScore);
        } else {
            return ResponseEntity.badRequest().body("can not find the average score for this ID");
        }
    }



}
