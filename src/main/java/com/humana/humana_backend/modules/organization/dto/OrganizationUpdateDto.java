package com.humana.humana_backend.modules.organization.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrganizationUpdateDto {
    private String legalName;
    private String RC;
    private String email;
    private String phone;
    private String country;
    private Integer numberOfEmployees;
}
