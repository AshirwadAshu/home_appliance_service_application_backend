package com.excel.homeas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.excel.homeas.constant.ApplicationConstants;
import com.excel.homeas.dto.AdminDto;
import com.excel.homeas.dto.AdminLoginDto;
import com.excel.homeas.dto.ApplianceDto;
import com.excel.homeas.dto.CustomerLoginDto;
import com.excel.homeas.dto.CustomerRegistrationDto;
import com.excel.homeas.dto.ServiceRequestsDto;
import com.excel.homeas.dto.TechnicianLoginDto;
import com.excel.homeas.dto.TechnicianRegistrationDto;
import com.excel.homeas.entity.Admin;
import com.excel.homeas.entity.Appliance;
import com.excel.homeas.entity.Customer;
import com.excel.homeas.entity.ServiceRequests;
import com.excel.homeas.entity.Technician;
import com.excel.homeas.exceptions.appliance.ApplianceException;
import com.excel.homeas.exceptions.customer.CustomerException;
import com.excel.homeas.exceptions.servicerequest.ServiceRequestException;
import com.excel.homeas.exceptions.technician.TechnicianException;
import com.excel.homeas.repository.AdminRepository;
import com.excel.homeas.repository.ApplianceRepository;
import com.excel.homeas.repository.CustomerRepository;
import com.excel.homeas.repository.ServiceRequestRepository;
import com.excel.homeas.repository.TechnicianRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final CustomerRepository customerRepository;

    private final TechnicianRepository technicianRepository;

    private final ServiceRequestRepository serviceRequestRepository;

    private final ApplianceRepository applianceRepository;
    
    private final AdminRepository adminRepository;

    // ------------------------[ Customer ]----------------------------

    @Override
    public Integer saveCustomerDetials(CustomerRegistrationDto dto) {
        Optional<Customer> optional = customerRepository.findByEmail(dto.getEmail());

        if (optional.isPresent()) {
            throw new CustomerException(ApplicationConstants.CUSTOMER_DETAILS_ALREADY_EXISTS);
        } else {
            Customer customer = Customer.builder()
                    .customerFirstName(dto.getCustomerFirstName())
                    .customerLastName(dto.getCustomerLastName())
                    .email(dto.getEmail())
                    .password(dto.getPassword())
                    .phoneNo(dto.getPhoneNo())
                    .address(dto.getAddress())
                    .build();

            customerRepository.save(customer);
            return 1;
        }
    }

    @Override
    public CustomerRegistrationDto getAllCustomerDetails(CustomerRegistrationDto dto) {
        Optional<Customer> optional = customerRepository.findByEmail(dto.getEmail());

        if (optional.isPresent()) {
            Customer customer = optional.get();

            return CustomerRegistrationDto.builder()
                    .customerId(customer.getCustomerId())
                    .customerFirstName(customer.getCustomerFirstName())
                    .customerLastName(customer.getCustomerLastName())
                    .email(customer.getEmail())
                    .password(customer.getPassword())
                    .phoneNo(customer.getPhoneNo())
                    .address(customer.getAddress())
                    .build();
        } else {
            throw new CustomerException(ApplicationConstants.NO_CUSTOMER_FOUND);
        }

    }
    
    @Override
    public CustomerLoginDto checkCustomerLogin(CustomerLoginDto dto) {
        Optional<Customer> optional = customerRepository.findByEmail(dto.getEmail());
        if (optional.isPresent()) {
            Customer customer = optional.get();
            if (customer.getPassword().equals(dto.getPassword())) {
                return CustomerLoginDto.builder()
                		.response(1)
                		.name(customer.getCustomerFirstName())
                		.email(customer.getEmail())
                		.build();
            } else {
                return CustomerLoginDto.builder()
                		.response(0)
                		.build();
            }
        } else {
            throw new CustomerException(ApplicationConstants.CUSTOMER_NOT_FOUND);
        }
    }

    // ---------------------------------[ Technician ]------------------------------

    @Override
    public Integer saveTechnicianDetails(TechnicianRegistrationDto dto) {
        Optional<Technician> optional = technicianRepository.findByEmail(dto.getEmail());

        if (optional.isPresent()) {
            throw new TechnicianException(ApplicationConstants.TECHNICIAN_DETAILS_ALREADY_EXISTS);
        } else {
        	Technician technician = Technician.builder()
                    .technicianFirstName(dto.getTechnicianFirstName())
                    .technicianLastName(dto.getTechnicianLastName())
                    .email(dto.getEmail())
                    .password(dto.getPassword())
                    .phoneNo(dto.getPhoneNo())
                    .address(dto.getAddress())
                    .status(dto.getStatus())
                    .build();
        	
        	technicianRepository.save(technician);
        	return 1;
        }
    }

    @Override
    public TechnicianRegistrationDto getTechnicianDetails(TechnicianRegistrationDto dto) {
        Optional<Technician> optional = technicianRepository.findByEmail(dto.getEmail());

        if (optional.isPresent()) {
            Technician technician = optional.get();

            return TechnicianRegistrationDto.builder()
                    .technicianId(technician.getTechnicianId())
                    .technicianFirstName(technician.getTechnicianFirstName())
                    .technicianLastName(technician.getTechnicianLastName())
                    .email(technician.getEmail())
                    .phoneNo(technician.getPhoneNo())
                    .address(technician.getAddress())
                    .status(technician.getStatus())
                    .build();

        } else {
            throw new TechnicianException(ApplicationConstants.NO_TECHNICIAN_FOUND);
        }

    }

    @Override
    public String updateTechnicianDetails(TechnicianRegistrationDto dto) {
        Optional<Technician> optional = technicianRepository.findByEmail(dto.getEmail());

        if (optional.isPresent()) {
            Technician technician = optional.get();

            Technician techObj = Technician.builder()
                    .technicianFirstName(dto.getTechnicianFirstName())
                    .technicianLastName(dto.getTechnicianLastName())
                    .email(dto.getEmail())
                    .password(dto.getPassword())
                    .phoneNo(dto.getPhoneNo())
                    .address(dto.getAddress())
                    .status(dto.getStatus())
                    .build();

            technician.setTechnicianFirstName(techObj.getTechnicianFirstName());
            technician.setTechnicianLastName(techObj.getTechnicianLastName());
            technician.setEmail(techObj.getEmail());
            technician.setPassword(techObj.getPassword());
            technician.setPhoneNo(techObj.getPhoneNo());
            technician.setAddress(techObj.getAddress());
            technician.setStatus(techObj.getStatus());

            return technicianRepository.save(technician).getEmail();
        } else {
            throw new TechnicianException(ApplicationConstants.TECHNICIAN_NOT_REGISTERED);
        }
    }

    @Override
    public String deleteTechnicianDetails(TechnicianRegistrationDto dto) {
        Optional<Technician> optional = technicianRepository.findByEmail(dto.getEmail());

        if (optional.isPresent()) {
            Technician technician = optional.get();

            technicianRepository.delete(technician);

            return ApplicationConstants.DELETED_SUCCESSFULLY;
        } else {
            throw new TechnicianException(ApplicationConstants.TECHNICIAN_DETAILS_NOT_FOUND);
        }
    }

    @Override
    public Integer checkTechnicianLogin(TechnicianLoginDto dto) {
        Optional<Technician> optional = technicianRepository.findByEmail(dto.getEmail());

        if (optional.isPresent()) {
            Technician technician = optional.get();

            if (technician.getPassword().equals(dto.getPassword())) {
                return 1;
            } else {
                return 0;
            }
        }
        throw new TechnicianException(ApplicationConstants.TECHNICIAN_NOT_REGISTERED);
    }

    // -------------------[ Appliance ]------------------------

    @Override
    public Integer saveApplianceDetails(ApplianceDto dto) {
        Optional<Customer> optional = customerRepository.findByEmail(dto.getEmail());

        if (optional.isPresent()) {
            Customer customer = optional.get();

            Appliance appliance = Appliance.builder()
                    .applianceBrand(dto.getApplianceBrand())
                    .yearOfManufacturing(dto.getYearOfManufacturing())
                    .productType(dto.getProductType())
                    .serialNo(dto.getSerialNo())
                    .warrentyStatus(dto.getWarrentyStatus())
                    .build();

            customer.setAppliance(appliance);
            appliance.setCustomer(customer);

            applianceRepository.save(appliance);
            return 1;
        } else {
            throw new ApplianceException(ApplicationConstants.APPLIANCE_ALREADY_EXISTS);
        }
    }

    @Override
    public List<ApplianceDto> getAllAppliances() {
        return applianceRepository.findAll().stream()
                .map(e -> ApplianceDto.builder()
                        .email(e.getCustomer().getEmail())
                        .applianceBrand(e.getApplianceBrand())
                        .yearOfManufacturing(e.getYearOfManufacturing())
                        .productType(e.getProductType())
                        .serialNo(e.getSerialNo())
                        .warrentyStatus(e.getWarrentyStatus())
                        .build())
                .toList();
    }

    @Override
    public Integer updateApplianceDetails(ApplianceDto dto) {
        Optional<Appliance> optional = applianceRepository.findByCustomerEmail(dto.getEmail());

        if (optional.isPresent()) {
            Appliance appliance = optional.get();

            Appliance applianceObj = Appliance.builder()
                    .applianceBrand(dto.getApplianceBrand())
                    .yearOfManufacturing(dto.getYearOfManufacturing())
                    .productType(dto.getProductType())
                    .serialNo(dto.getSerialNo())
                    .warrentyStatus(dto.getWarrentyStatus())
                    .build();

            appliance.setApplianceBrand(applianceObj.getApplianceBrand());
            appliance.setYearOfManufacturing(appliance.getYearOfManufacturing());
            appliance.setProductType(dto.getProductType());
            appliance.setSerialNo(applianceObj.getSerialNo());
            appliance.setWarrentyStatus(appliance.getWarrentyStatus());

            return applianceRepository.save(appliance).getApplianceId();
        }
        throw new ApplianceException(ApplicationConstants.APPLIANCE_NOT_FOUND);
    }

    @Override
    public String deleteApplianceDetails(ApplianceDto dto) {
        Optional<Appliance> optional = applianceRepository.findByCustomerEmail(dto.getEmail());

        if (optional.isPresent()) {
            applianceRepository.delete(optional.get());

            return ApplicationConstants.DELETED_SUCCESSFULLY;
        } else {
            return ApplicationConstants.FAILED_TO_DELETE;
        }
    }

    // ------------------------[ Service ]-----------------------------

    @Override
    public String saveServiceRequest(ServiceRequestsDto dto) {
        Optional<Customer> optional = customerRepository.findByEmail(dto.getEmail());

        if (optional.isPresent()) {
            Customer customer = optional.get();
            if (customer.getServiceRequests() == null) {
                ServiceRequests serviceRequests = ServiceRequests.builder()
                        .createdOn(dto.getCreatedOn())
                        .updatedOn(dto.getUpdatedOn())
                        .appointmentDate(dto.getAppointmentDate())
                        .serviceStatus(dto.getServiceStatus())
                        .comment(dto.getComment())
                        .build();
                customer.setServiceRequests(serviceRequests);
                serviceRequests.setCustomer(customer);
                return customerRepository.save(customer).getEmail();
            } else {
                return ApplicationConstants.SERVICE_REQUEST_NOT_FOUND;
            }
        }
        return null;
    }

    @Override
    public List<ServiceRequestsDto> getAllServiceRequests() {
        return serviceRequestRepository.findAll().stream().map(e -> ServiceRequestsDto.builder()
                .email(e.getCustomer().getEmail())
                .createdOn(e.getCreatedOn())
                .updatedOn(e.getUpdatedOn())
                .appointmentDate(e.getAppointmentDate())
                .serviceStatus(e.getServiceStatus())
                .comment(e.getComment())
                .build()).toList();
    }

    @Override
    public Integer updateServiceRequestDetails(ServiceRequestsDto dto) {
        Optional<ServiceRequests> optional = serviceRequestRepository.findByCustomerEmail(dto.getEmail());
        if (optional.isPresent()) {
            ServiceRequests requests = optional.get();
            ServiceRequests serviceRequests = ServiceRequests.builder()
                    .serviceStatus(dto.getServiceStatus())
                    .comment(dto.getComment())
                    .build();
            
            requests.setServiceStatus(serviceRequests.getServiceStatus());
            requests.setComment(serviceRequests.getComment());

            Integer save = serviceRequestRepository.save(requests).getCustomer().getCustomerId();
            
            if(save != null) {
            	return 1;
            }
        }
        throw new ServiceRequestException(ApplicationConstants.SERVICE_REQUEST_NOT_FOUND);
    }
    
    // ---------------- [ Admin ] ------------------

	@Override
	public Integer saveAdminInfo(AdminDto dto) {
		Admin admin = Admin.builder()
		.adminFirstName(dto.getAdminFirstName())
		.adminLastName(dto.getAdminLastName())
		.email(dto.getEmail())
		.password(dto.getPassword())
		.phoneNo(dto.getPhoneNo())
		.address(dto.getAddress())
		.build();
		
		Integer adminId = adminRepository.save(admin).getAdminId();
		if(adminId != null) {
			return 1;
		} else {
			throw new CustomerException(ApplicationConstants.CUSTOMER_NOT_FOUND);
		}
	}

	@Override
	public AdminLoginDto checkAdminLogin(AdminLoginDto dto) {
		Technician.builder()
		.email(dto.getEmail())
		.build();
				
		Optional<Admin> optional = adminRepository.findByEmail(dto.getEmail());
		if(optional.isPresent()) {
			Admin admin = optional.get();
			if(admin.getPassword().equals(dto.getPassword())){
				return AdminLoginDto.builder()
						.response(1)
						.name(admin.getAdminFirstName())
						.email(admin.getEmail())
						.build();
			} else {
				return AdminLoginDto.builder()
						.response(0)
						.build();
			}
		}
//		return throw Admin not found exp; complete this
		return null;
	}
}
