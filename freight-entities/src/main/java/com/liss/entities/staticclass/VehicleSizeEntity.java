package com.liss.entities.staticclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liss.embeded.AbstractTimeStamp;
import com.liss.entities.offers.FreightEntity;
import com.liss.entities.translate.TranslateStaticEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** VehicleSize est une entité static qui permet d'avoir
 * la description sur la taille du véhicule
 * **/

@Entity(name = "VehicleSize")
@Table(name = "vehicle_sizes")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleSizeEntity extends AbstractTimeStamp {

    @Column(name = "description")
    @JsonProperty(value = "description", required = false)
    private String description;



    @OneToMany(mappedBy = "vehicleSize", fetch = FetchType.LAZY)
    @JsonProperty(value = "translates")
    @JsonManagedReference
    private Set<TranslateStaticEntity> translates = new HashSet<>();
}
