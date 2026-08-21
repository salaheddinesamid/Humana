package com.humana.humana_backend.modules.audit.dto;

import com.humana.humana_backend.modules.audit.model.AuditLog;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AuditDto {
    private Long id;
    private String entityType;
    private String entityId;
    private UUID userId;
    private UUID organizationId;
    private String ipAddress;
    private String userAgent;
    private String details;
    private LocalDateTime createdAt;

    public AuditDto(AuditLog audit){
        this.id = audit.getId();
        this.entityType = audit.getEntityType();
        this.entityId = audit.getEntityId();
        this.userId = audit.getUserId();
        this.organizationId = audit.getOrganizationId();
        this.ipAddress = audit.getIpAddress();
        this.userAgent = audit.getUserAgent();
        this.details = audit.getDetails();
        this.createdAt = audit.getCreatedAt();
    }
}
