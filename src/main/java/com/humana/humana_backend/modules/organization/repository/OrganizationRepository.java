package com.humana.humana_backend.modules.organization.repository;

import com.humana.humana_backend.modules.organization.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {

    boolean existsByLegalNameOrRC(String legalName, String RC);
}
