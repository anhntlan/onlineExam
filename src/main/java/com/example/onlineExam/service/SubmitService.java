package com.example.onlineExam.service;

import com.example.onlineExam.model.Submit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SubmitService {
    boolean createSubmit(Submit submit);
    List<Submit> getAllSubmits();
    Optional<Submit> getSubmitById(int id);
    boolean updateSubmit(int id, Submit submit);
    boolean deleteSubmit(int id);
    List<Submit> getSubmitsByUserId(int userId);
    List<Submit> getSubmitsByExamId(int examId);
    Submit getSubmitByUserIdAndExamId(int userId, int examId);
    int getTotalSubmitsByExamId(int examId);
    int getTotalSubmitsByUserId(int userId);

}
