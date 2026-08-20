package com.humana.humana_backend.initializer;

import com.humana.humana_backend.modules.user_management.model.Role;
import com.humana.humana_backend.modules.user_management.model.RoleName;
import com.humana.humana_backend.modules.user_management.model.User;
import com.humana.humana_backend.modules.user_management.repository.RoleRepository;
import com.humana.humana_backend.modules.user_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.existsByUsername("super.admin@humana.com")){
            return;
        }
        initSuperAdmin();
    }

    private void initSuperAdmin(){
        Role superAdmin = roleRepository
                .findByRoleName(RoleName.SUPER_ADMIN)
                .orElseThrow();

        User user = new User();
        user.setRoles(List.of(superAdmin));
        user.setUsername("super.admin@humana.com");
        user.setPassword(passwordEncoder.encode("ChangeMe123"));

        userRepository.save(user);
    }
}
