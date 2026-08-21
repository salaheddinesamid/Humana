package com.humana.humana_backend.modules.organization.service;

import com.humana.humana_backend.modules.organization.model.Organization;

import java.util.List;
import java.util.UUID;

public interface OrganizationQueryService {

    Organization getOrganization(UUID id);
    List<Organization> getAll();
}
