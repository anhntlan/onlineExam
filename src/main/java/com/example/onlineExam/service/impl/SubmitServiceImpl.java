package com.example.onlineExam.service.impl;

import com.example.onlineExam.model.Submit;
import com.example.onlineExam.repository.SubmitRepository;
import com.example.onlineExam.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubmitServiceImpl implements SubmitService {
    @Autowired
     SubmitRepository submitRepository;

    @Override
    public boolean createSubmit(Submit submit) {
        try {
            submitRepository.save(submit);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Submit> getAllSubmits() {
        return submitRepository.findAll();
    }

    @Override
    public Optional<Submit> getSubmitById(int id) {
        return submitRepository.findById(id);
    }

    @Override
    public boolean updateSubmit(int id, Submit submit) {
        Optional<Submit> existingSubmit = submitRepository.findById(id);
        if (existingSubmit.isPresent()) {
            submit.setUserId(existingSubmit.get().getUserId());
            submit.setExamId(existingSubmit.get().getExamId());
            submit.setStart(existingSubmit.get().getStart());
            submit.setEnd(existingSubmit.get().getEnd());
            submitRepository.save(submit);
            return true;
        } else {
            return false;
        }    }

    @Override
    public boolean deleteSubmit(int id) {
        Optional<Submit> existingSubmit = submitRepository.findById(id);
        if (existingSubmit.isPresent()) {
            submitRepository.delete(existingSubmit.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Submit> getSubmitsByUserId(int userId) {
        return submitRepository.findByUserId(userId);
    }

    @Override
    public List<Submit> getSubmitsByExamId(int examId) {
        return submitRepository.findByExamId(examId);
    }

    @Override
    public Submit getSubmitByUserIdAndExamId(int userId, int examId) {
        return submitRepository.findByUserIdAndExamId(userId, examId);
    }

    @Override
    public int getTotalSubmitsByExamId(int examId) {
        return submitRepository.countByExamId(examId);
    }

    @Override
    public int getTotalSubmitsByUserId(int userId) {
        return submitRepository.countByUserId(userId);
    }
}
