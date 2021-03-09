package com.liss.entities.translate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liss.embeded.AbstractTimeStamp;
import com.liss.entities.compagny.CompanyEntity;
import com.liss.entities.staticclass.AdditionalEquipmentEntity;
import com.liss.entities.staticclass.ChargingModeEntity;
import com.liss.entities.staticclass.VehicleSizeEntity;
import com.liss.entities.staticclass.VehicleTypeEntity;

import javax.persistence.*;

/** Translate static est la table de jointure entre les classes static et l'entité Language qui nous permettra de faire la traduction dans une langue **/

@Entity(name = "TranslateStatic")
@Table(name = "translate_statics")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TranslateStaticEntity extends AbstractTimeStamp {

    @Column(name = "description")
    @JsonProperty(value = "description", required = false )
    private String description;

    @ManyToOne(optional=true, cascade= CascadeType.ALL)
    @JoinColumn(name="language_id", referencedColumnName="id", nullable = true)
    @JsonProperty(value = "language", required = false)
    private LanguageEntity language;

    @ManyToOne(optional=true, cascade= CascadeType.ALL)
    @JoinColumn(name="additional_equipment_id", referencedColumnName="id", nullable = true)
    @JsonProperty(value = "additionalEquipment", required = false)
    private AdditionalEquipmentEntity additionalEquipment;

    @ManyToOne(optional=true, cascade= CascadeType.ALL)
    @JoinColumn(name="charging_mode_id", referencedColumnName="id", nullable = true)
    @JsonProperty(value = "chargingMode", required = false)
    private ChargingModeEntity chargingMode;

    @ManyToOne(optional=true, cascade= CascadeType.ALL)
    @JoinColumn(name="vehicle_size_id", referencedColumnName="id", nullable = true)
    @JsonProperty(value = "vehicleSize", required = false)
    private VehicleSizeEntity vehicleSize;

    @ManyToOne(optional=true, cascade= CascadeType.ALL)
    @JoinColumn(name="vehicle_type_id", referencedColumnName="id", nullable = true)
    @JsonProperty(value = "vehicleType", required = false)
    private VehicleTypeEntity vehicleType;
}
