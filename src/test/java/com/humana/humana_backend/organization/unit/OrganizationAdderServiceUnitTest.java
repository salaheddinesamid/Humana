package com.humana.humana_backend.organization.unit;

import com.humana.humana_backend.modules.organization.dto.NewOrganizationDto;
import com.humana.humana_backend.modules.organization.mapper.OrganizationMapper;
import com.humana.humana_backend.modules.organization.model.Organization;
import com.humana.humana_backend.modules.organization.repository.OrganizationRepository;
import com.humana.humana_backend.modules.organization.service.implementation.OrganizationAdderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class OrganizationAdderServiceUnitTest {

    @Mock
    private OrganizationRepository organizationRepository;

    @Mock
    private OrganizationMapper organizationMapper;

    @InjectMocks
    private OrganizationAdderServiceImpl organizationAdderService;

    private NewOrganizationDto dto;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        dto = new NewOrganizationDto();
        dto.setLegalName("OrganizationX");
        dto.setRC("ABCD");
        dto.setEmail("organization.x@example.com");
        dto.setNumberOfEmployees(30);
        dto.setPhone("089280829");
    }

    @Test
    void testAddNewOrganizationSuccess(){
        when(organizationRepository.existsByLegalNameOrRC(
                dto.getLegalName(),
                dto.getRC()
        )).thenReturn(false);

        Organization savedOrganization = new Organization();
        savedOrganization.setLegalName(dto.getLegalName());
        savedOrganization.setEmail(dto.getEmail());
        savedOrganization.setPhone(dto.getPhone());
        savedOrganization.setCountry(dto.getCountry());
        savedOrganization.setRC(dto.getRC());

        when(organizationRepository.save(any(Organization.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Organization result = organizationAdderService.add(dto);
        assertNotNull(result);
        assertEquals(dto.getLegalName(), result.getLegalName());

    }

    @Test
    void testAddNewOrganizationThrowsAlreadyExist(){}
}
