package com.school_management_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private MyClass myClass;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "payment_type")
    private String paymentType;
}
