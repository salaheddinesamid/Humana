package com.humana.humana_backend.modules.organization.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID organizationId;

    @Column(name = "legal_name", nullable = false, unique = true)
    private String legalName;

    @Column(name = "RC", unique = true)
    private String RC;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "country")
    private String country;

    @Column(name = "number_of_employees")
    private Integer numberOfEmployees;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrganizationStatus status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    public Organization(
            String legalName,
            String RC,
            String email,
            String phone,
            String country,
            Integer numberOfEmployees
    ){
        this.legalName = legalName;
        this.RC = RC;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.numberOfEmployees = numberOfEmployees;
    }

    public Organization() {

    }
}
