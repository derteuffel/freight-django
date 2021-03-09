package com.liss.entities.offers;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liss.embeded.AbstractTimeStamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*** l'entité Destinantion permet d'avoir les lieux de chargement et de déchargement  ***/

@Entity(name="Destination")
@Table(name="destinations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DestinationEntity extends AbstractTimeStamp {

	@Column(name = "postal_code")
	@JsonProperty(value = "postal_code", required = false)
	private String postalCode;
	
	@Column(name = "city")
	@JsonProperty(value = "city", required = false)
	private String city;
	
	@Column(name = "country")
	@JsonProperty(value = "country", required = false)
	private String country;

	
	@Column(name = "latitude")
	@JsonProperty(value = "latitude", required = false)
	private String latitude;
	
	@Column(name = "longitude")
	@JsonProperty(value = "longitude", required = false)
	private String longitude;

	/** permet de numeroter les destinations pour un fret **/
	@Column(name = "number")
	@JsonProperty(value = "number", required = false)
	private int number;

	/**
	 * Permet de savoir si c'est une destination de chargement ou de déchargement
	 */
	@Column(name = "isLoading")
	@JsonProperty(value = "isLoading", required = false)
	private Boolean isLoading;
	
	/**
	 * @author Issofa 
	 */
	/*@ManyToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="freight_id", referencedColumnName="id", nullable = true)
	@JsonProperty(value = "freight", required = false)
    private FreightEntity freight;*/
	
	@ManyToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="vehicle_id", referencedColumnName="id", nullable = true)
	@JsonProperty(value = "vehicle", required = false)
	VehicleEntity vehicle;
	
	
}
