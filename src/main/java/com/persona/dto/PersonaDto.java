package com.persona.dto;

import com.persona.util.HairColor;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonaDto implements Serializable {

    private Long personaId;
    private String personaName;
    private String personaLastName;
    private String personaAddress;
    private Long personaPhoneNum;
    private HairColor personaHairColor;
    private Date createdAt;
    private Date updatedAt;
}