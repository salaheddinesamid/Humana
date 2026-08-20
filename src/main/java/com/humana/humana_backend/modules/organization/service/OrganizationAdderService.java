package com.humana.humana_backend.modules.organization.service;

import com.humana.humana_backend.modules.organization.dto.NewOrganizationDto;
import com.humana.humana_backend.modules.organization.model.Organization;
import jakarta.validation.ValidationException;

public interface OrganizationAdderService {

    /**
     * Creates a new organization from the provided data.
     *
     * @param dto the organization data received from the client
     * @return the created and persisted organization
     * @throws ConflictException if an organization with the same unique information already exists
     * @throws ValidationException if the provided data violates business rules
     */
    Organization add(NewOrganizationDto dto) throws ValidationException;
}
