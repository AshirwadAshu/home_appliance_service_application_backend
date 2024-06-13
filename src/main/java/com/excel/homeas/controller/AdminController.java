package com.excel.homeas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.homeas.dto.AdminDto;
import com.excel.homeas.dto.AdminLoginDto;
import com.excel.homeas.response.Response;
import com.excel.homeas.service.ApplicationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	
	private final ApplicationService applicationService;
	
	@PostMapping("/signup")
	public ResponseEntity<Response<Integer>> saveApplianceInfo(@RequestBody AdminDto dto) {
        Integer info = applicationService.saveAdminInfo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(Response.<Integer>builder()
                .data(info)
                .isError(false)
                .message("Successfully Registered.")
                .build());
    }
	
	@PostMapping("/signin")
	public ResponseEntity<Response<AdminLoginDto>> adminLogin(@RequestBody AdminLoginDto dto){
		AdminLoginDto loginDto = applicationService.checkAdminLogin(dto);
		return ResponseEntity.status(HttpStatus.OK).body(Response.<AdminLoginDto>builder()
                .data(loginDto)
                .isError(false)
                .message("Login Successful.")
                .build());
	}
}