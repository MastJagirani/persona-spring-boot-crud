package com.personaapp.personaservices.util;

import com.persona.dto.PersonaDto;
import com.persona.model.Persona;
import com.persona.util.HairColor;
import java.util.Collections;
import java.util.List;

public class ObjectFactoryUtil {

    public static PersonaDto personaDtoMock(){
        PersonaDto personaDto = new PersonaDto();
        personaDto.setPersonaName(ConstantUtil.PERSONA_NAME);
        personaDto.setPersonaLastName(ConstantUtil.PERSONA_LAST_NAME);
        personaDto.setPersonaAddress(ConstantUtil.PERSONA_ADDRESS);
        personaDto.setPersonaPhoneNum(ConstantUtil.PERSONA_PHONE_NUM);
        personaDto.setPersonaHairColor(HairColor.BLACK);
        return personaDto;
    }
    public static Persona personaMock(){
        Persona persona = new Persona();
        persona.setPersonaName(ConstantUtil.PERSONA_NAME);
        persona.setPersonaLastName(ConstantUtil.PERSONA_LAST_NAME);
        persona.setPersonaAddress(ConstantUtil.PERSONA_ADDRESS);
        persona.setPersonaPhoneNum(ConstantUtil.PERSONA_PHONE_NUM);
        persona.setPersonaHairColor(HairColor.BLACK);
        return persona;
    }
    public static List<Persona> personaListMock(){
        Persona persona = new Persona();
        persona.setPersonaName(ConstantUtil.PERSONA_NAME);
        persona.setPersonaLastName(ConstantUtil.PERSONA_LAST_NAME);
        persona.setPersonaAddress(ConstantUtil.PERSONA_ADDRESS);
        persona.setPersonaHairColor(HairColor.BLACK);
        return Collections.singletonList(persona);
    }

}
