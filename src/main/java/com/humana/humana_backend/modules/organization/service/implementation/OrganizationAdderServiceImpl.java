package com.humana.humana_backend.modules.organization.service.implementation;

import com.humana.humana_backend.common.exception.OrganizationAlreadyExistsException;
import com.humana.humana_backend.modules.organization.dto.NewOrganizationDto;
import com.humana.humana_backend.modules.organization.mapper.OrganizationMapper;
import com.humana.humana_backend.modules.organization.model.Organization;
import com.humana.humana_backend.modules.organization.repository.OrganizationRepository;
import com.humana.humana_backend.modules.organization.service.OrganizationAdderService;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

@Service
public class OrganizationAdderServiceImpl implements OrganizationAdderService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    public OrganizationAdderServiceImpl(OrganizationRepository organizationRepository, OrganizationMapper organizationMapper) {
        this.organizationRepository = organizationRepository;
        this.organizationMapper = organizationMapper;
    }

    @Override
    public Organization add(NewOrganizationDto dto) throws ValidationException {
        if (organizationRepository.existsByLegalNameOrRC(
                dto.getLegalName(),
                dto.getRC()
        )){
            throw new OrganizationAlreadyExistsException(
                    String.format("Organization with legal name: %s is already exists", dto.getLegalName())
            );
        }

        Organization mappedOrganization = organizationMapper
                .mapDto(dto);

        return organizationRepository.save(mappedOrganization);
    }
}
