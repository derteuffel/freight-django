package com.liss.entitiesUtilis;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.liss.embeded.AbstractConstanteEntity;

@Entity(name="VehicleTypeUtil")
@Table(name="vehicle_type_util")
public class VehicleTypeEntityUtil extends AbstractConstanteEntity{
	
	/** Donne le type de vehicule
	 * 1. dépaneuse
	 * 2. camion
	 * **/
}
