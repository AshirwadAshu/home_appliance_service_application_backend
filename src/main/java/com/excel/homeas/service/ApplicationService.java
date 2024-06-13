package com.excel.homeas.service;

import java.util.List;

import com.excel.homeas.dto.AdminDto;
import com.excel.homeas.dto.AdminLoginDto;
import com.excel.homeas.dto.ApplianceDto;
import com.excel.homeas.dto.CustomerLoginDto;
import com.excel.homeas.dto.CustomerRegistrationDto;
import com.excel.homeas.dto.ServiceRequestsDto;
import com.excel.homeas.dto.TechnicianLoginDto;
import com.excel.homeas.dto.TechnicianRegistrationDto;

public interface ApplicationService {


    // -----[ Customer ]-----

    public Integer saveCustomerDetials(CustomerRegistrationDto dto);

    public CustomerRegistrationDto getAllCustomerDetails(CustomerRegistrationDto dto);

    public CustomerLoginDto checkCustomerLogin(CustomerLoginDto dto);


    // ------[ Technician ]-----

    public Integer saveTechnicianDetails(TechnicianRegistrationDto dto);

    public TechnicianRegistrationDto getTechnicianDetails(TechnicianRegistrationDto dto);

    public String updateTechnicianDetails(TechnicianRegistrationDto dto);

    public String deleteTechnicianDetails(TechnicianRegistrationDto dto);

    public Integer checkTechnicianLogin(TechnicianLoginDto dto);


    // -----[ Appliance ]-----

    public Integer saveApplianceDetails(ApplianceDto dto);

    List<ApplianceDto> getAllAppliances();

    public Integer updateApplianceDetails(ApplianceDto dto);

    public String deleteApplianceDetails(ApplianceDto dto);


    // -----[ Service ]-----

    public String saveServiceRequest(ServiceRequestsDto dto);

    public List<ServiceRequestsDto> getAllServiceRequests();

    public Integer updateServiceRequestDetails(ServiceRequestsDto dto);
    
    // -----[ Admin ]-----

	public Integer saveAdminInfo(AdminDto dto);

	public AdminLoginDto checkAdminLogin(AdminLoginDto dto);
}
