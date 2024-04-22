package com.example.onlineExam.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "exams")
@Getter
@Setter
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private String type; // Loại kỳ thi (Tự do, Thời gian)

    private int duration; // Thời gian làm bài (phút)

    private String status; // Trạng thái kỳ thi (Mở, Đóng)

}

