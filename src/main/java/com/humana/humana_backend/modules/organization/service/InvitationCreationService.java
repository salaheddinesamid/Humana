package com.humana.humana_backend.modules.organization.service;

import com.humana.humana_backend.modules.organization.model.Invitation;
import com.humana.humana_backend.modules.user_management.model.User;

public interface InvitationCreationService {

    Invitation create(
            User user,
            String email
    );
}
