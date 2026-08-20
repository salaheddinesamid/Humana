package com.humana.humana_backend.modules.organization.service.implementation;

import com.humana.humana_backend.modules.organization.dto.OrganizationUpdateDto;
import com.humana.humana_backend.modules.organization.model.Organization;
import com.humana.humana_backend.modules.organization.repository.OrganizationRepository;
import com.humana.humana_backend.modules.organization.service.OrganizationUpdateService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationUpdateServiceImpl implements OrganizationUpdateService {
    private final OrganizationRepository organizationRepository;

    public OrganizationUpdateServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization update(UUID uuid, OrganizationUpdateDto dto) {
        Organization organization = organizationRepository
                .findById(uuid)
                .orElseThrow();

        Organization updatedOrganization = updateDetails(
                organization,
                dto
        );

        return organizationRepository.save(updatedOrganization);
    }

    private Organization updateDetails(
            Organization organization,
            OrganizationUpdateDto details
    ){
        if (details.getLegalName() != null){
            organization.setLegalName(details.getLegalName());
        }

        if (details.getRC() != null){
            organization.setRC(details.getRC());
        }

        if (details.getCountry() != null){
            organization.setCountry(details.getCountry());
        }

        if(details.getEmail() != null){
            organization.setEmail(details.getEmail());
        }

        if(details.getPhone() != null){
            organization.setPhone(details.getPhone());
        }

        return organization;
    }
}
