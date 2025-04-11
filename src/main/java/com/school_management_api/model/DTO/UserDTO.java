package com.school_management_api.model.DTO;

import com.school_management_api.model.type.EUserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phoneNumber;
    private EUserType userType;
}
