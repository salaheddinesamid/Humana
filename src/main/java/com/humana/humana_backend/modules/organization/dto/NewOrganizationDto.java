package com.humana.humana_backend.modules.organization.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NewOrganizationDto {

    @NotBlank(message = "Organization legal name is required")
    private String legalName;

    @NotBlank(message = "Organization RC is required")
    private String RC;

    @NotBlank(message = "Organization email is required")
    private String email;

    @NotBlank(message = "Organization phone is required")
    private String phone;

    @NotBlank(message = "Organization country is required")
    private String country;

    private Integer numberOfEmployees;

}
