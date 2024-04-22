package com.example.onlineExam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="question")
@Getter
@Setter
public class Question {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAnswer;
    private Long examId;


}
