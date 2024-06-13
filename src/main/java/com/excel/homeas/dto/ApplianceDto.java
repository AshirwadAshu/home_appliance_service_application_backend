package com.excel.homeas.dto;

import java.time.LocalDate;

import com.excel.homeas.enums.ApplianceBrand;
import com.excel.homeas.enums.ProductType;
import com.excel.homeas.enums.WarrentyStatus;

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
public class ApplianceDto {

    private String email;
    private ApplianceBrand applianceBrand;
    private LocalDate yearOfManufacturing;
    private ProductType productType;
    private String serialNo;
    private WarrentyStatus warrentyStatus;

}
