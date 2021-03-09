package com.liss.entitiesUtilis;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.liss.embeded.AbstractConstanteEntity;

@Entity(name="StatusFreightUtil")
@Table(name="status_freight_util")
public class StatusFreightEntityUtil extends AbstractConstanteEntity{

	/** donne le status d'un freigt
	 * 1. Accepté 
	 * 2. choisissez le transporteur
	 * 3.rechercher un transporteur
	 * 4. chercher à nouveau
	 * 5. en attente d'offre 
	 */
}
