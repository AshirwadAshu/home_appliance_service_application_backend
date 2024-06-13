package com.excel.homeas.entity;

import com.excel.homeas.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer technicianId;
    private String technicianFirstName;
    private String technicianLastName;
    private String email;
    private String password;
    private String phoneNo;
    private String address;

    @Enumerated(EnumType.STRING)
    private Status status;
}
