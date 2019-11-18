package com.personaapp.personaservices.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.persona.dto.PersonaListResponseDto;
import com.persona.dto.PersonaResponseDto;
import com.persona.model.Persona;
import com.persona.repository.PersonaRepository;
import com.persona.service.PersonaService;
import com.persona.service.PersonaServiceImpl;
import com.personaapp.personaservices.util.ConstantUtil;
import com.personaapp.personaservices.util.ObjectFactoryUtil;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonaServiceTests {

    @Mock
    private PersonaRepository personaRepository;
    private PersonaService personaService;

    @Before
    public void setUp() {
        personaService = new PersonaServiceImpl(personaRepository, new ObjectMapper());
    }

    @Test
    public void testGetPersona(){
        when(personaRepository.findAll()).thenReturn(ObjectFactoryUtil.personaListMock());
        PersonaListResponseDto personaMessageDto = personaService.getAllPersona();
        assertNotNull(personaMessageDto);
    }

    @Test
    public void testGetPersonaById(){
        when(personaRepository.findById(anyLong())).thenReturn(Optional.of(ObjectFactoryUtil.personaMock()));
        PersonaResponseDto personaMessageDto = personaService.getPersonaById(1L);
        assertNotNull(personaMessageDto);
    }

    @Test
    public void testSaveOrUpdatePersona(){
        when(personaRepository.save(any(Persona.class)))
                .thenReturn(ObjectFactoryUtil.personaMock());
        PersonaResponseDto personaMessageDto = personaService
                .saveOrUpdatePersona(ObjectFactoryUtil.personaDtoMock());
        assertEquals(ConstantUtil.SUCCESS_MESSAGE, personaMessageDto.getResponseMessage());
        assertEquals(ConstantUtil.PERSONA_NAME, personaMessageDto.getPersonaDto().getPersonaName());
    }

    @Test
    public void testDeletePersona(){
        Long personaId = 0L;
        personaRepository.deleteById(anyLong());
        verify(personaRepository,times(1)).deleteById(eq(personaId));
    }

}