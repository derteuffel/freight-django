package com.liss.entities.offers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liss.embeded.AbstractTimeStamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/** Cette entity InfoVehicle donne les information sur le vehicule **/

@Entity(name = "InfoVehicle")
@Table(name  = "info_vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoVehicleEntity extends AbstractTimeStamp {

    /** Mètre de plancher **/
    @Column(name = "mpl")
    @JsonProperty(value = "mpl", required = false)
    private String mpl;

    @Column(name ="description")
    @JsonProperty(value = "description", required = false)
    private String description;

    @Column(name = "length", columnDefinition = "Decimal(10,2) default '0.00'")
    @JsonProperty(value = "length", required = false)
    private Double length;

    @Column(name = "width", columnDefinition = "Decimal(10,2) default '0.00'")
    @JsonProperty(value = "width", required = false)
    private Double width;

    @Column(name = "height", columnDefinition = "Decimal(10,2) default '0.00'")
    @JsonProperty(value = "height", required = false)
    private Double height;

    @Column(name = "volume", columnDefinition = "Decimal(10,2) default '0.00'")
    @JsonProperty(value = "volume", required = false)
    private Double volume;

    @Column(name = "capacity")
    @JsonProperty(value = "capacity", required = false)
    private String capacity;

    @OneToMany
    @JsonProperty(value = "freights")
    @JsonManagedReference
    private List<FreightEntity> freights = new ArrayList<>();


}
