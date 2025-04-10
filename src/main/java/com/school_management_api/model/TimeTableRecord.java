package com.school_management_api.model;

import com.school_management_api.model.type.EWeekday;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "time_table_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeTableRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "time_table_id")
    private TimeTable timeTable;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private TimeSlot slot;

    @Enumerated(EnumType.STRING)
    private EWeekday weekday;
}