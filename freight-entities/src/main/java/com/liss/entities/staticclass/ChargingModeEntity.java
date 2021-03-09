package com.liss.entities.staticclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liss.embeded.AbstractTimeStamp;
import com.liss.entities.translate.TranslateStaticEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/** ChangingMode est une entité statique qui permet d'avoir
 * la description sur le mode de chargement
 * **/

@Entity(name="ChangingMode")
@Table(name = "charging_modes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChargingModeEntity extends AbstractTimeStamp {

    @Column(name = "description")
    @JsonProperty(value = "description", required = false)
    private String description;

    @OneToMany(mappedBy = "chargingMode", fetch= FetchType.LAZY)
    @JsonProperty(value = "translates")
    @JsonManagedReference
    private Set<TranslateStaticEntity> translates = new HashSet<>();
}
