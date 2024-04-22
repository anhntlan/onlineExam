package com.example.onlineExam.controller;

import com.example.onlineExam.model.Submit;
import com.example.onlineExam.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("submit")
public class SubmitController {
    @Autowired
    SubmitService submitService;

    @GetMapping("")
    public List<Submit> getAllSubmits() {
        return submitService.getAllSubmits();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addSubmit(@RequestBody Submit submit) {
        boolean isCreated = submitService.createSubmit(submit);
        if (isCreated) {
            return ResponseEntity.ok("Added a new submit");
        } else {
            return ResponseEntity.badRequest().body("Failed to create new submit");
        }
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity<?> getSubmitById(@PathVariable int id) {
        Optional<Submit> submit = submitService.getSubmitById(id);
        if (submit.isPresent()) {
            return ResponseEntity.ok(submit.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editSubmit(@PathVariable int id, @RequestBody Submit submit) {
        boolean isUpdated = submitService.updateSubmit(id, submit);
        if (isUpdated) {
            return ResponseEntity.ok("Submit updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update submit");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSubmit(@PathVariable int id) {
        boolean isDeleted = submitService.deleteSubmit(id);
        if (isDeleted) {
            return ResponseEntity.ok("Submit deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete submit");
        }
    }
    @GetMapping("/byUser/{userId}")
    public List<Submit> getSubmitsByUserId(@PathVariable int userId) {
        return submitService.getSubmitsByUserId(userId);
    }

    @GetMapping("/byExam/{examId}")
    public List<Submit> getSubmitsByExamId(@PathVariable int examId) {
        return submitService.getSubmitsByExamId(examId);
    }

    @GetMapping("/byUsernExam/{userId}/{examId}")
    public ResponseEntity<?> getSubmitByUserIdAndExamId(@PathVariable int userId, @PathVariable int examId) {
        Submit submit = submitService.getSubmitByUserIdAndExamId(userId, examId);
        if (submit != null) {
            return ResponseEntity.ok(submit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/total-exam/{examId}")
    public ResponseEntity<?> getTotalSubmitsByExamId(@PathVariable int examId) {
        int totalSubmits = submitService.getTotalSubmitsByExamId(examId);
        return ResponseEntity.ok(totalSubmits);
    }
    @GetMapping("/total-user/{userId}")
    public ResponseEntity<?> getTotalSubmitsByUserId(@PathVariable int userId) {
        int totalSubmits = submitService.getTotalSubmitsByUserId(userId);
        return ResponseEntity.ok(totalSubmits);
    }
}
