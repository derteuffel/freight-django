package com.liss.entitiesUtilis;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.liss.embeded.AbstractConstanteEntity;


@Entity(name="SecurityUtil")
@Table(name="security_util")
public class SecurityEntityUtil extends AbstractConstanteEntity {
	/** donne le type securité pour le vehicule
	 * 1. sangles
	 * 2. equerres
	 */
}

