package com.persona.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.persona.dto.PersonaDto;
import com.persona.dto.PersonaListResponseDto;
import com.persona.dto.PersonaResponseDto;
import com.persona.model.Persona;
import com.persona.repository.PersonaRepository;
import com.persona.util.ResponseMessage;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class PersonaServiceImpl implements PersonaService {

    private PersonaRepository personaRepository;
    private ObjectMapper objectMapper;

    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository, ObjectMapper objectMapper){
        this.personaRepository = personaRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public PersonaListResponseDto getAllPersona(){
        log.debug("In PersonaServiceImpl -> getAllPersona() Called");
        return getAllPersonaWithMessage(ResponseMessage.DATA_PRESENT_MESSAGE);
    }

    @Override
    public PersonaResponseDto getPersonaById(Long personaId) {
        log.debug("In PersonaServiceImpl -> getPersonaById() Called | personaId {}", personaId);
        Optional<Persona> personaDetails = personaRepository.findById(personaId);
        return new PersonaResponseDto(personaDetails
                .filter(pd -> !ObjectUtils.isEmpty(pd)).map(personaEntity ->
                        objectMapper.convertValue(personaEntity, PersonaDto.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ResponseMessage.PERSONA_NOT_FOUND)),
                ResponseMessage.DATA_PRESENT_MESSAGE);
    }

    @Override
    public PersonaResponseDto saveOrUpdatePersona(PersonaDto personaDto) {
        log.debug("In PersonaServiceImpl -> saveOrUpdatePersona() Called | personaDto {}", personaDto);
        return new PersonaResponseDto(
            objectMapper.convertValue(personaRepository.save(objectMapper.convertValue(personaDto,
                    Persona.class)),PersonaDto.class), ResponseMessage.SUCCESS_SAVE_UPDATE_MESSAGE);
    }

    @Override
    public PersonaListResponseDto deletePersona(Long personaId){
        log.debug("In PersonaServiceImpl -> deletePersona() Called | personaId {}", personaId);
        Persona personaDetails = personaRepository.findById(personaId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,ResponseMessage.INVALID_PERSONA_ID + personaId));
        personaRepository.delete(personaDetails);
        return getAllPersonaWithMessage(ResponseMessage.DELETE_SUCCESS_MESSAGE + personaId);
    }

    private PersonaListResponseDto getAllPersonaWithMessage(String responseMessage){
       log.debug("In PersonaServiceImpl -> getAllPersonaWithMessage() Called | responseMessage {}", responseMessage);
       return new PersonaListResponseDto(personaRepository.findAll()
                .stream()
                .map(this::convertToPersonaDto)
                .collect(Collectors.toList()), responseMessage);
    }

    private PersonaDto convertToPersonaDto(Persona persona) {
        return objectMapper.convertValue(persona, PersonaDto.class);
    }
}