package com.excel.homeas.dto;

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

public class AdminDto {
	private String adminFirstName;
    private String adminLastName;
    private String email;
    private String password;
    private String phoneNo;
    private String address;
}
