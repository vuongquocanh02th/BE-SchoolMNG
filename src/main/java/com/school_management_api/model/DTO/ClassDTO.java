package com.school_management_api.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassDTO {
    private Long id;
    private String className;
    private Long classTypeId;
    private String schoolYear;
    private Long homeroomTeacherId;
    private Integer maxStudents;
}
