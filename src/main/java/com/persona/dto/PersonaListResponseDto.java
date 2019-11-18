package com.persona.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonaListResponseDto {

    private String responseMessage;
    private List<PersonaDto> personaDtoList;
    public PersonaListResponseDto(){
    }
    public PersonaListResponseDto(List<PersonaDto> personaDtoList, String message){
        this.personaDtoList = personaDtoList;
        this.responseMessage = message;
    }
}
