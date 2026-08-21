package com.humana.humana_backend.modules.audit.service.implementation;

import com.humana.humana_backend.modules.audit.model.AuditAction;
import com.humana.humana_backend.modules.audit.model.AuditLog;
import com.humana.humana_backend.modules.audit.repository.AuditLogRepository;
import com.humana.humana_backend.modules.audit.service.AuditService;
import com.humana.humana_backend.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditServiceImpl implements AuditService {

    private final AuditLogRepository auditLogRepository;
    private final SecurityUtils securityUtils;

    public AuditServiceImpl(AuditLogRepository auditLogRepository, SecurityUtils securityUtils) {
        this.auditLogRepository = auditLogRepository;
        this.securityUtils = securityUtils;
    }

    @Override
    public void log(AuditAction action, String entityType, String entityId, String details) {
        AuditLog auditLog = new AuditLog();

        auditLog.setAction(action.toString());
        auditLog.setEntityType(entityType);
        auditLog.setEntityId(entityId);
        auditLog.setUserId(
                securityUtils.getCurrentUserId()
        );
        auditLog.setCreatedAt(LocalDateTime.now());

        auditLogRepository.save(auditLog);
    }
}
