package com.humana.humana_backend.modules.organization.controller;

import com.humana.humana_backend.modules.organization.dto.NewOrganizationDto;
import com.humana.humana_backend.modules.organization.dto.OrganizationUpdateDto;
import com.humana.humana_backend.modules.organization.service.implementation.OrganizationAdderServiceImpl;
import com.humana.humana_backend.modules.organization.service.implementation.OrganizationQueryServiceImpl;
import com.humana.humana_backend.modules.organization.service.implementation.OrganizationUpdateServiceImpl;
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
    private final OrganizationUpdateServiceImpl organizationUpdateService;

    public OrganizationController(OrganizationAdderServiceImpl organizationAdderService, OrganizationQueryServiceImpl organizationQueryService, OrganizationUpdateServiceImpl organizationUpdateService) {
        this.organizationAdderService = organizationAdderService;
        this.organizationQueryService = organizationQueryService;
        this.organizationUpdateService = organizationUpdateService;
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

    @GetMapping("get_all")
    public ResponseEntity<?> getAllOrganizations(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(organizationQueryService.getAll());
    }

    /**
     * Updates an existing organization.
     *
     * @param id the unique identifier of the organization to update
     * @param dto the data containing the fields to be updated
     * @return a response containing the updated organization
     */
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateOrganization(@PathVariable UUID id, @RequestBody OrganizationUpdateDto dto){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(organizationUpdateService.update(
                        id, dto
                ));
    }
}
