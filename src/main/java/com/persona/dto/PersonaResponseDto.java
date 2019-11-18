package com.persona.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonaResponseDto {

    private String responseMessage;
    private PersonaDto personaDto;
    public PersonaResponseDto(){
    }
    public PersonaResponseDto(PersonaDto personaDto, String message){
        this.personaDto = personaDto;
        this.responseMessage = message;
    }
}
