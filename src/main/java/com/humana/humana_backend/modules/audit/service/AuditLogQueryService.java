package com.humana.humana_backend.modules.audit.service;

import com.humana.humana_backend.modules.audit.dto.AuditDto;

import java.util.List;
import java.util.UUID;

public interface AuditLogQueryService {

    List<AuditDto> getAllAuditLogs(
            UUID organizationId,
            int page,
            int size
    );
}
