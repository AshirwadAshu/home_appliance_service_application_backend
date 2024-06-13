package com.excel.homeas.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ApplianceBrand {
    LG("LG"),
    SONY("SONY"),
    DLINK("DLINK"),
    TPLINK("TPLINK"),
    SAMSUNG("SAMSUNG"),
    TOSHIBA("TOSHIBA"),
    BOSCH("BOSCH");

    private final String applianceBrand;
}
