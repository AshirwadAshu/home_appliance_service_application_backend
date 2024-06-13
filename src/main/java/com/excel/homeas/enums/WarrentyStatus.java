package com.excel.homeas.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum WarrentyStatus {
    UNDERWARRENTY("UNDERWARRENTY"),
    OUTOFWARRENTY("OUTOFWARRENTY");

    private final String warrentyStatus;
}
