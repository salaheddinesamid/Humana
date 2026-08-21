package com.humana.humana_backend.modules.audit.service;

import com.humana.humana_backend.modules.audit.model.AuditAction;

public interface AuditService {

    void log(
            AuditAction action,
            String entityType,
            String entityId,
            String details
    );
}
