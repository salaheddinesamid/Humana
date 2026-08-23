package com.humana.humana_backend.modules.user_management.service.implementation;

import com.humana.humana_backend.common.exception.UnmatchedPasswordsException;
import com.humana.humana_backend.modules.auth.dto.AccountActivationDto;
import com.humana.humana_backend.modules.organization.model.Invitation;
import com.humana.humana_backend.modules.organization.model.InvitationStatus;
import com.humana.humana_backend.modules.organization.repository.InvitationRepository;
import com.humana.humana_backend.modules.user_management.model.User;
import com.humana.humana_backend.modules.user_management.repository.UserRepository;
import com.humana.humana_backend.modules.user_management.service.UserActivationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private final InvitationRepository invitationRepository;
    private final UserRepository userRepository;

    public UserActivationServiceImpl(InvitationRepository invitationRepository, UserRepository userRepository) {
        this.invitationRepository = invitationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void activate(AccountActivationDto dto, String token) {
        // Fetch the invitation by token
        Invitation invitation = invitationRepository
                .findByToken(token)
                .orElseThrow();

        // Add user password
        User user = invitation.getUser();
        if(!dto.getRawPassword().equals(dto.getConfirmedPassword())){
            throw new UnmatchedPasswordsException();
        }
        user.setPassword(dto.getRawPassword());

        // Save the user
        userRepository.save(user);

        // Update and save the invitation
        invitation.setStatus(InvitationStatus.ACCEPTED);
        invitation.setAcceptedAt(LocalDateTime.now());

        invitationRepository.save(invitation);

    }
}
