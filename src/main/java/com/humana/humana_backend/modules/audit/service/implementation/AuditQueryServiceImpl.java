package com.humana.humana_backend.modules.audit.service.implementation;

import com.humana.humana_backend.modules.audit.dto.AuditDto;
import com.humana.humana_backend.modules.audit.repository.AuditLogRepository;
import com.humana.humana_backend.modules.audit.service.AuditLogQueryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuditQueryServiceImpl implements AuditLogQueryService {

    private final AuditLogRepository auditLogRepository;

    public AuditQueryServiceImpl(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    public List<AuditDto> getAllAuditLogs(
            UUID organizationId,
            int page,
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return auditLogRepository
                .findAllByOrganizationId(
                        organizationId,
                        pageable
                )
                .stream().map(AuditDto::new)
                .toList();
    }
}
