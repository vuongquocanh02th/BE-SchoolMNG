package com.school_management_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "my_class")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_name", nullable = false, length = 20)
    private String className;

    @ManyToOne
    @JoinColumn(name = "class_type_id")
    private ClassType classType;

    @Column(name = "school_year", length = 10)
    private String schoolYear;

    @ManyToOne
    @JoinColumn(name = "homeroom_teacher_id")
    private StaffRecord homeroomTeacher;

    @Column(name = "max_students")
    private Integer maxStudents;
}
