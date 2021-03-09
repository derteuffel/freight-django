package com.liss.entitiesUtilis;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.liss.embeded.AbstractConstanteEntity;


@Entity(name="ChargementUtil")
@Table(name="Chargement_util")
public class ChargementEntityUtil extends AbstractConstanteEntity{
	
	/** permet de savoir comment le chargement sera effectué
	 * 1. Chargement par le haut
	 * 2. Chargement sur le cote
	 * 3. Chargement pâr l'arriere
	 */
	
}