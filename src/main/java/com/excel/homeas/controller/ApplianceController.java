package com.excel.homeas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.homeas.dto.ApplianceDto;
import com.excel.homeas.response.Response;
import com.excel.homeas.service.ApplicationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/appliance")
public class ApplianceController {

    private final ApplicationService applicationService;

    @PostMapping("/save")
    public ResponseEntity<Integer> saveApplianceInfo(@RequestBody ApplianceDto dto) {
        Integer result = applicationService.saveApplianceDetails(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ApplianceDto>> getAllAppliances() {
        List<ApplianceDto> list = applicationService.getAllAppliances();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PutMapping("/update")
    public ResponseEntity<Integer> updateApplianceDetails(@RequestBody ApplianceDto dto) {
        Integer details = applicationService.updateApplianceDetails(dto);
        return ResponseEntity.status(HttpStatus.OK).body(details);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Response<String>> deleteApplianceDetails(@RequestBody ApplianceDto dto) {
        String deleted = applicationService.deleteApplianceDetails(dto);
        return ResponseEntity.status(HttpStatus.OK).body(Response.<String>builder().data(deleted).isError(false).message("Deleted Successfully").build());
    }
}
