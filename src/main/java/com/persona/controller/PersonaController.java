package com.persona.controller;

import com.persona.dto.PersonaDto;
import com.persona.dto.PersonaListResponseDto;
import com.persona.dto.PersonaResponseDto;
import com.persona.service.PersonaService;
import com.persona.util.ObjectValidator;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/persona")
@Slf4j
public class PersonaController {

    private PersonaService personaService;

    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }

    @GetMapping
    public PersonaListResponseDto getAllPersona() {
        log.debug("In PersonaController -> getAllPersona() Called");
        return personaService
                .getAllPersona();
    }

    @GetMapping("/{personaId}")
    public PersonaResponseDto getPersonaById(@Valid @PathVariable Long personaId) {
        log.debug("In PersonaController -> getPersonaById() Called");
        return personaService
                .getPersonaById(personaId);
    }

    @PostMapping
    public PersonaResponseDto saveOrUpdatePersona(@Valid @RequestBody PersonaDto personaDto) {
        log.debug("In saveOrUpdatePersona -> saveOrUpdatePersona() Called");
        ObjectValidator.validatePersonaDto(personaDto);
        return personaService
                .saveOrUpdatePersona(personaDto);
    }

    @DeleteMapping("/{personaId}")
    public PersonaListResponseDto deletePersona(@Valid @PathVariable Long personaId){
        log.debug("In PersonaController -> DeletePersona() Called");
        return personaService
                .deletePersona(personaId);
    }

}
