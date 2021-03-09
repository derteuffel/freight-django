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


/** VehicleType est une enitité qui est statique et donne
 * la description sur le type de véhicule
 * **/

@Entity(name = "VehicleType")
@Table(name="vehicle_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleTypeEntity extends AbstractTimeStamp {

    @Column(name = "description")
    @JsonProperty(value = "description", required = false)
    private String description;

    @OneToMany(mappedBy = "vehicleType", fetch = FetchType.LAZY)
    @JsonProperty(value = "translates")
    @JsonManagedReference
    private Set<TranslateStaticEntity> translates = new HashSet<>();
}
