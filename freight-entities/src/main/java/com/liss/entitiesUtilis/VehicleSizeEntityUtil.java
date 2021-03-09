package com.liss.entitiesUtilis;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.liss.embeded.AbstractConstanteEntity;

@Entity(name="VehicleSizeUtil")
@Table(name="vehicle_size_util")
public class VehicleSizeEntityUtil extends AbstractConstanteEntity{
	
	/** Donne le type de camion qui doit transporter la marchandise 
	 * 1. tout type
	 * 2. Semi-remorque
	 * 3. Double Remork
	 * 4. Forgon
	 * **/
}
