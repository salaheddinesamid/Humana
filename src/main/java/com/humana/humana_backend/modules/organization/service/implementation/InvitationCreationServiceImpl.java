package com.humana.humana_backend.modules.organization.service.implementation;

import com.humana.humana_backend.modules.organization.model.Invitation;
import com.humana.humana_backend.modules.organization.model.InvitationStatus;
import com.humana.humana_backend.modules.organization.repository.InvitationRepository;
import com.humana.humana_backend.modules.organization.service.InvitationCreationService;
import com.humana.humana_backend.modules.organization.utils.InvitationUtils;
import com.humana.humana_backend.modules.user_management.model.User;
import org.springframework.stereotype.Service;

@Service
public class InvitationCreationServiceImpl implements InvitationCreationService {

    private final InvitationUtils invitationUtils;
    private final InvitationRepository invitationRepository;

    public InvitationCreationServiceImpl(InvitationUtils invitationUtils, InvitationRepository invitationRepository) {
        this.invitationUtils = invitationUtils;
        this.invitationRepository = invitationRepository;
    }

    @Override
    public Invitation create(
            User user,
            String email
    ) {
        Invitation invitation = new Invitation();
        invitation.setUser(user);
        invitation.setToken(invitationUtils.generateToken());
        invitation.setStatus(InvitationStatus.PENDING);

        return invitationRepository.save(invitation);
    }
}
