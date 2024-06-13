package com.excel.homeas.dto;

import com.excel.homeas.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TechnicianRegistrationDto {
    private Integer technicianId;
    private String technicianFirstName;
    private String technicianLastName;
    private String email;
    private String password;
    private String phoneNo;
    private String address;
    private Status status;
}
