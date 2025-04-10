package com.school_management_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exam_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentRecord student;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    private String status;
}