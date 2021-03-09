package com.liss.entities.offers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.liss.embeded.AbstractTimeStamp;

import com.liss.entities.management.UserEntity;
import com.liss.entities.staticclass.AdditionalEquipmentEntity;
import com.liss.entities.staticclass.ChargingModeEntity;
import com.liss.entities.staticclass.VehicleSizeEntity;
import com.liss.entities.staticclass.VehicleTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity freight
 * **/

@Entity(name="Freight")
@Table(name="freights")
@Data @AllArgsConstructor @NoArgsConstructor
public class FreightEntity extends AbstractTimeStamp {

	//desactiver un fret
	@Column(name="enable")
	private boolean enable = true;


	/**
	 * @author Issofa 
	 * un fret à plusieurs points de chargement et(ou) de dechargement qui constitue un trajet
	 */
	//@OneToMany(mappedBy="freight", fetch=FetchType.LAZY)
	@ManyToMany(cascade=CascadeType.ALL)//(fetch=FetchType.EAGER)
	@JoinTable(name="freight_trajet",
			joinColumns={@JoinColumn(name="freight_id")},
			inverseJoinColumns={@JoinColumn(name="destination_id")})
	@JsonProperty(value = "trajet", required = false )
	private List<DestinationEntity> trajet = new ArrayList<>();
	
	//@author Issofa
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="id", nullable = true)
	private UserEntity user;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="info_vehicule_id", referencedColumnName="id", nullable = true)
	@JsonProperty(value = "infoVehicle", required = false)
	private InfoVehicleEntity infoVehicle;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vehicule_size_id", referencedColumnName="id", nullable = true)
	@JsonProperty(value = "vehicleSize", required = false)
	private VehicleSizeEntity vehicleSize;

	@ManyToMany(cascade=CascadeType.ALL)//(fetch=FetchType.EAGER)
	@JoinTable(name="freight_additional_equipment",
			joinColumns={@JoinColumn(name="freight_id")},
			inverseJoinColumns={@JoinColumn(name="additional_equipment_id")})
	@JsonProperty(value = "additional_equipments", required = false )
	private List<AdditionalEquipmentEntity> additional_equipments = new ArrayList<>();

	@ManyToMany(cascade=CascadeType.ALL)//(fetch=FetchType.EAGER)
	@JoinTable(name="freight_vehicle_type",
			joinColumns={@JoinColumn(name="freight_id")},
			inverseJoinColumns={@JoinColumn(name="vehicle_type_id")})
	@JsonProperty(value = "vehicle_types", required = false )
	private List<VehicleTypeEntity> vehicle_types = new ArrayList<>();

	@ManyToMany(cascade=CascadeType.ALL)//(fetch=FetchType.EAGER)
	@JoinTable(name="freight_charging_mode",
			joinColumns={@JoinColumn(name="freight_id")},
			inverseJoinColumns={@JoinColumn(name="charging_mode_id")})
	@JsonProperty(value = "charging_modes", required = false )
	private List<ChargingModeEntity> charging_modes = new ArrayList<>();


}
