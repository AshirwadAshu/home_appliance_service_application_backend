package com.excel.homeas.entity;

import java.time.LocalDate;

import com.excel.homeas.enums.ServiceStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer serviceId;

    @Column(name = "created_on")
    private LocalDate createdOn;

    @Column(name = "updated_on")
    private LocalDate updatedOn;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "service_status")
    private ServiceStatus serviceStatus;

    @Column(name = "comments")
    private String comment;

    @JoinColumn(name = "customer_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Customer customer;
}
