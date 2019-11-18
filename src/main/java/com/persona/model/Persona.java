package com.persona.model;

import com.persona.util.HairColor;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "persona")
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    private Long personaId;

    @Column(name = "persona_name")
    private String personaName;

    @Column(name = "persona_last_name")
    private String personaLastName;

    @Column(name = "persona_phone_num")
    private Long personaPhoneNum;

    @Column(name = "persona_address")
    private String personaAddress;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "persona_hair_color")
    private HairColor personaHairColor;

    @Column(nullable = false, updatable = false, name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false, name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
