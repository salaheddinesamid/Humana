package com.humana.humana_backend.modules.organization.service.implementation;

import com.humana.humana_backend.modules.organization.model.Organization;
import com.humana.humana_backend.modules.organization.repository.OrganizationRepository;
import com.humana.humana_backend.modules.organization.service.OrganizationQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationQueryServiceImpl implements OrganizationQueryService {

    private final OrganizationRepository organizationRepository;

    public OrganizationQueryServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization getOrganization(UUID id) {
        return organizationRepository
                .findById(id)
                .orElseThrow();
    }

    @Override
    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }
}
