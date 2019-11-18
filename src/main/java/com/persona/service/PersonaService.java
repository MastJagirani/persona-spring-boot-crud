package com.persona.service;

import com.persona.dto.PersonaDto;
import com.persona.dto.PersonaListResponseDto;
import com.persona.dto.PersonaResponseDto;

public interface PersonaService {
     PersonaListResponseDto getAllPersona();
     PersonaResponseDto getPersonaById(Long personaId);
     PersonaResponseDto saveOrUpdatePersona(PersonaDto personaDto);
     PersonaListResponseDto deletePersona(Long personaId);
}
