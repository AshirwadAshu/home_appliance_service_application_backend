package com.excel.homeas.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProductType {
    FAN("FAN"),
    AIRCONDITIONER("AIRCONDITIONER"),
    WASHINGMACHINE("WASHINGMACHINE"),
    WIRELESSROUTER("WIRELESSROUTER"),
    COFFEEDISPENSER("COFFEEDISPENSER"),
    REFRIGERATOR("REFRIGERATOR");

    private final String productType;
}
