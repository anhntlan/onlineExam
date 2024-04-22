package com.example.onlineExam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Submit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private int userId;
    private int examId;
    private String start;
    private Date end;

}
