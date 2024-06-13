package com.excel.homeas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.homeas.dto.CustomerLoginDto;
import com.excel.homeas.dto.CustomerRegistrationDto;
import com.excel.homeas.response.Response;
import com.excel.homeas.service.ApplicationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/customer")
@RestController
@CrossOrigin
public class CustomerController {

    private final ApplicationService applicationService;

    @PostMapping("/save")
    public ResponseEntity<Response<Integer>> registerCustomer(@RequestBody CustomerRegistrationDto dto) {
        Integer savedCustomerDetials = applicationService.saveCustomerDetials(dto);
        return ResponseEntity.status(HttpStatus.OK).body(Response.<Integer>builder()
                .data(savedCustomerDetials)
                .isError(false)
                .message("Successfully Registered")
                .build());
    }

    @GetMapping("/get")
    public ResponseEntity<Response<CustomerRegistrationDto>> getAllCustomers(@RequestBody CustomerRegistrationDto dto) {
        CustomerRegistrationDto allCustomerDetails = applicationService.getAllCustomerDetails(dto);
        return ResponseEntity.status(HttpStatus.OK).body(Response.<CustomerRegistrationDto>builder()
                .data(allCustomerDetails)
                .isError(false)
                .message("Here Is the Customer Data")
                .build());
    }

    @PostMapping("/login")
    public ResponseEntity<Response<CustomerLoginDto>> loginCustomer(@RequestBody CustomerLoginDto dto) {
        CustomerLoginDto login = applicationService.checkCustomerLogin(dto);
        return ResponseEntity.status(HttpStatus.OK).body(Response.<CustomerLoginDto>builder()
                .data(login)
                .isError(false)
                .message("Done")
                .build());
    }

}
