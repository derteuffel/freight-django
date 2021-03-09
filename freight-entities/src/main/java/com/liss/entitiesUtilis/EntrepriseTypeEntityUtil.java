package com.liss.entitiesUtilis;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.liss.embeded.AbstractConstanteEntity;

@Entity(name="EntrepriseTypeUtil")
@Table(name="entreprise_type_util")
public class EntrepriseTypeEntityUtil extends AbstractConstanteEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** donne le type d'entreprise
	 * 1. Commissionaire
	 * 2. Transporteur
	 */
	
}
