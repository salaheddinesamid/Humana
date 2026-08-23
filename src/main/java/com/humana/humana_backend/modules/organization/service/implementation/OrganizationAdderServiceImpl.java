package com.humana.humana_backend.modules.organization.service.implementation;

import com.humana.humana_backend.common.exception.OrganizationAlreadyExistsException;
import com.humana.humana_backend.modules.organization.dto.NewOrganizationDto;
import com.humana.humana_backend.modules.organization.mapper.OrganizationMapper;
import com.humana.humana_backend.modules.organization.model.Invitation;
import com.humana.humana_backend.modules.organization.model.Organization;
import com.humana.humana_backend.modules.organization.repository.OrganizationRepository;
import com.humana.humana_backend.modules.organization.service.OrganizationAdderService;
import com.humana.humana_backend.modules.user_management.model.Role;
import com.humana.humana_backend.modules.user_management.model.RoleName;
import com.humana.humana_backend.modules.user_management.model.User;
import com.humana.humana_backend.modules.user_management.repository.RoleRepository;
import com.humana.humana_backend.modules.user_management.repository.UserRepository;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrganizationAdderServiceImpl implements OrganizationAdderService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final InvitationCreationServiceImpl invitationCreationService;

    public OrganizationAdderServiceImpl(OrganizationRepository organizationRepository, OrganizationMapper organizationMapper, UserRepository userRepository, RoleRepository roleRepository, InvitationCreationServiceImpl invitationCreationService) {
        this.organizationRepository = organizationRepository;
        this.organizationMapper = organizationMapper;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.invitationCreationService = invitationCreationService;
    }

    @Transactional
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

        // Find Organization admin:
        Role role = roleRepository
                .findByRoleName(RoleName.ORGANIZATION_ADMIN)
                .orElseThrow();

        // Initialize an organization admin:
        User organizationAdmin = new User();
        organizationAdmin.setUsername(dto.getAdminEmail());

        User savedAdmin = userRepository.save(organizationAdmin);
        // Create and send invitation

        Invitation invitation = invitationCreationService
                .create(savedAdmin, dto.getAdminEmail());


        // Return new organization
        return organizationRepository.save(mappedOrganization);
    }
}
