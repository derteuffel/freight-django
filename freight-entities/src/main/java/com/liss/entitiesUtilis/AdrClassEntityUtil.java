package com.liss.entitiesUtilis;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.liss.embeded.AbstractConstanteEntity;

@Entity(name="AdrClassUtil")
@Table(name="adr_class_util")
public class AdrClassEntityUtil extends AbstractConstanteEntity{
	
	/** dire le type de marchandise dangereuse a transporter
	 * le transporteur doit avoir un document attestant qu'il peut 
	 * faire le transport de ce type
	 */
	
	
}
