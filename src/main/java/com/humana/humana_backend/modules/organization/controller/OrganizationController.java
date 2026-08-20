package com.humana.humana_backend.modules.organization.controller;

import com.humana.humana_backend.modules.organization.dto.NewOrganizationDto;
import com.humana.humana_backend.modules.organization.service.implementation.OrganizationAdderServiceImpl;
import com.humana.humana_backend.modules.organization.service.implementation.OrganizationQueryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationController {

    private final OrganizationAdderServiceImpl organizationAdderService;
    private final OrganizationQueryServiceImpl organizationQueryService;

    public OrganizationController(OrganizationAdderServiceImpl organizationAdderService, OrganizationQueryServiceImpl organizationQueryService) {
        this.organizationAdderService = organizationAdderService;
        this.organizationQueryService = organizationQueryService;
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

    /**
     * Retrieves an organization by its unique identifier.
     *
     * @param id the unique identifier of the organization
     * @return a response containing the requested organization
     */
    @GetMapping("{id}")
    public ResponseEntity<?> getOrganization(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(organizationQueryService.getOrganization(id));
    }
}
