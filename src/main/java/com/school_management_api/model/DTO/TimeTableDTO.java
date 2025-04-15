package com.school_management_api.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeTableDTO {
    private Long id;
    private String name;
    private Long classId;
    private String type;
}