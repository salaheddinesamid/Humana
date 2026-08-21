package com.humana.humana_backend.modules.audit.controller;

import com.humana.humana_backend.modules.audit.service.implementation.AuditQueryServiceImpl;
import com.humana.humana_backend.modules.user_management.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/system/audit")
public class AuditController {

    private final AuditQueryServiceImpl auditQueryService;

    public AuditController(AuditQueryServiceImpl auditQueryService) {
        this.auditQueryService = auditQueryService;
    }

    @GetMapping("")
    public ResponseEntity<?> getSystemAudit(
            @RequestParam int page, @RequestParam int size
    ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.status(HttpStatus.OK)
                .body(null);
    }
}
