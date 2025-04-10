package com.school_management_api.model;

import com.school_management_api.model.type.EExamType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "exams")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exam_name")
    private String examName;

    @Enumerated(EnumType.STRING)
    @Column(name = "exam_type")
    private EExamType examType;

    private Integer semester;

    @Column(name = "school_year")
    private String schoolYear;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
