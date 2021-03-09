package com.liss.entities.offers;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liss.embeded.AbstractTimeStamp;

import com.liss.entities.management.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
@Entity(name="Vehicle")
@Table(name="vehicles")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleEntity extends AbstractTimeStamp {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "mpl") //mètre de plancher
	private Double mpl=-1.0;
	
	@Column(name = "tonnage")
	private Double tonnage=-1.0;
	
	/** taille du vehicule ==> semi-remorque || double remorque  || solo || fourgon || double remorque **/
	@Column(name = "size_vehicle")
	private String sizeOfVehicle;
	
	/** type de vehicule **/
	@Column(name = "vehicle_type")
	private String vehicleType;
	
	/********************** Autres exigences **********************/
	// longueur
	@Column(name = "length")
	private Double length=-1.0;
	
	// largeur
	@Column(name = "width")
	private Double width=-1.0;
   
	// volume ( m3)
	@Column(name = "volume")
	private Double volume=-1.0;
	
	// hauteur du camion
	@Column(name = "hauteur")
	private Double hauteur=-1.0;
	
	// chargement ==> par le haut , par le côté, par l'arriere
	@Column(name = "chargement")
	private String chargement;
	
	// classe ADR ==> faire une  selection de la classe ADR
	@Column(name = "adr_classe")
	String adrClass;	
	//desactiver un vehicle
	@Column(name="enable")
	private boolean enable = true;
	
	// temps de disponibilité du véhicule
	@Column(name = "date1") // heure debut 
	private Date date1;
	
	@Column(name = "date2") // heure fin
	private Date date2;
	/**
	 * @author Issofa 
	 * un fret à plusieurs points de chargement et(ou) de dechargement qui constitue un trajet
	 */
	@OneToMany(mappedBy="vehicle", fetch=FetchType.LAZY) 
	private List<DestinationEntity> trajet = new ArrayList<>();
 
	//@author Issofa
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="id", nullable = true)
	@JsonProperty(value = "account", required = false)
	private UserEntity account;
	
	
}
