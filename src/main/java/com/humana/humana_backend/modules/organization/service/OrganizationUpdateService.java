package com.humana.humana_backend.modules.organization.service;

import com.humana.humana_backend.modules.organization.dto.OrganizationUpdateDto;
import com.humana.humana_backend.modules.organization.model.Organization;

import java.util.UUID;

public interface OrganizationUpdateService {

    Organization update(UUID id, OrganizationUpdateDto dto);
}
