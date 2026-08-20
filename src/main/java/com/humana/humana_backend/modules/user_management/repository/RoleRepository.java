package com.humana.humana_backend.modules.user_management.repository;

import com.humana.humana_backend.modules.user_management.model.Role;
import com.humana.humana_backend.modules.user_management.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
