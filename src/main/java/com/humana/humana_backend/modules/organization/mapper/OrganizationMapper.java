package com.humana.humana_backend.modules.organization.mapper;

import com.humana.humana_backend.modules.organization.dto.NewOrganizationDto;
import com.humana.humana_backend.modules.organization.model.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper {

    public Organization mapDto(
            NewOrganizationDto dto
    ){
        return new Organization(
                dto.getLegalName(),
                dto.getRC(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getCountry(),
                dto.getNumberOfEmployees()
        );
    }
}
