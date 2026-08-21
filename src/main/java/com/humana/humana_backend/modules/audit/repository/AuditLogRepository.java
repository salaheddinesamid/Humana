package com.humana.humana_backend.modules.audit.repository;

import com.humana.humana_backend.modules.audit.model.AuditLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    Page<AuditLog> findAllByOrganizationId(UUID organizationId, Pageable pageable);
}
