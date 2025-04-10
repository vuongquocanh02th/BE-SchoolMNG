package com.school_management_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "class_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String name;
}