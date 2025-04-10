package com.school_management_api.model;

import com.school_management_api.model.type.EAcademic;
import com.school_management_api.model.type.EConduct;
import com.school_management_api.model.type.EResult;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "states")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentRecord student;

    @Enumerated(EnumType.STRING)
    private EConduct conduct;

    @Enumerated(EnumType.STRING)
    private EAcademic academic;

    @Enumerated(EnumType.STRING)
    private EResult result;

    @Column(name = "school_year")
    private String schoolYear;
}