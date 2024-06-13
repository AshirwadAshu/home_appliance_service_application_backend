package com.excel.homeas.dto;

import java.time.LocalDate;

import com.excel.homeas.enums.ServiceStatus;

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
public class ServiceRequestsDto {

    private String email;
    private LocalDate createdOn;
    private LocalDate updatedOn;
    private LocalDate appointmentDate;
    private ServiceStatus serviceStatus;
    private String comment;
}
