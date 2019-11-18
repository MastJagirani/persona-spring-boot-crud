package com.persona.util;

import com.persona.dto.PersonaDto;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
public class ObjectValidator {

    private ObjectValidator(){

    }
    public static void validatePersonaDto(PersonaDto personaDto) {
        log.debug("In ObjectValidator -> validatePersonaDto() Called");
        if (!isStringOnlyAlphabet(personaDto.getPersonaName())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "PersonName cannot contain Alphanumeric Characters");
        }
        if (!isStringOnlyAlphabet(personaDto.getPersonaLastName())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "PersonLastName cannot contain Alphanumeric Characters");
        }
        if (!isStringAlphanumeric(personaDto.getPersonaAddress())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "PersonAddress cannot contain Alphanumeric Characters");
        }
        if (isHairColorPresent(personaDto.getPersonaHairColor().name()) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "PersonaHairColor cannot contain Alphanumeric Characters");

        }

    }

    private static boolean isStringOnlyAlphabet(String str) {
        return Objects.nonNull(str) && (str.matches("^[a-zA-Z]*$"));
    }

    private static boolean isStringAlphanumeric(String str) {
        return Objects.nonNull(str) && (str.matches("[a-zA-Z0-9]+"));
    }

    private static HairColor isHairColorPresent(String hairColor) {
        log.debug("In ObjectValidator -> isHairColorPresent() hairColor{}", hairColor);
        for (HairColor hc : HairColor.values()) {
            if (hc.name().equalsIgnoreCase(hairColor))
                return hc;
        }
        return null;
    }
}
