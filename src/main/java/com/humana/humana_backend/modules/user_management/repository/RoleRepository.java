package com.humana.humana_backend.modules.user_management.repository;

import com.humana.humana_backend.modules.user_management.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
