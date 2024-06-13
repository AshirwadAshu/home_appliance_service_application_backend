package com.excel.homeas.entity;

import java.time.LocalDate;

import com.excel.homeas.enums.ApplianceBrand;
import com.excel.homeas.enums.ProductType;
import com.excel.homeas.enums.WarrentyStatus;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "appliances")
public class Appliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appliance_id")
    private Integer applianceId;

    @Column(name = "appliance_brand")

    @Enumerated(EnumType.STRING)
    private ApplianceBrand applianceBrand;

    @Column(name = "year_of_manufacturing")
    private LocalDate yearOfManufacturing;

    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column(name = "product_serial")
    private String serialNo;

    @Column(name = "warranty_status")
    @Enumerated(EnumType.STRING)
    private WarrentyStatus warrentyStatus;

    @JoinColumn(name = "customer_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Customer customer;
}
