package com.humana.humana_backend.modules.organization.controller;

import com.humana.humana_backend.modules.organization.dto.NewOrganizationDto;
import com.humana.humana_backend.modules.organization.service.implementation.OrganizationAdderServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationController {

    private final OrganizationAdderServiceImpl organizationAdderService;

    public OrganizationController(OrganizationAdderServiceImpl organizationAdderService) {
        this.organizationAdderService = organizationAdderService;
    }

    /**
     * Creates a new organization.
     *
     * <p>The request body is validated before being passed to the service layer.</p>
     *
     * @param dto the data required to create the organization
     * @return a response containing the newly created organization
     */
    @PostMapping("/new")
    public ResponseEntity<?> addNewOrganization(
            @Valid @RequestBody NewOrganizationDto dto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(organizationAdderService.add(dto));
    }
}
