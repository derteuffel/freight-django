package com.liss.entities.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liss.embeded.AbstractTimeStamp;
import lombok.Data;


/*** Permission permet d'avoir les fonctionnalité relatif a l'application ***/


@Entity(name="Permission")
@Table(name="permissions")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PermissionEntity extends AbstractTimeStamp {

    @Column(name="code", unique = true)
    @JsonProperty(value = "code", required = true )
    private String code;

    @Column(name="description")
    @JsonProperty(value = "description", required = false )
    private String description;

}
