package com.school_management_api.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffRecordDTO {
    private Long id;
    private Long userId;
    private String fullName;
    private String address;
    private String specialization;
}
