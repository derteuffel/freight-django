package com.liss.entitiesUtilis; 

import javax.persistence.Entity;
import javax.persistence.Table;

import com.liss.embeded.AbstractConstanteEntity;

@Entity(name="TypeGoodsUtil")
@Table(name="type_goods_util")

public class TypeGoodsEntityUtil extends AbstractConstanteEntity{
	
	/** donne le type de marchandise a transporter
	 * 1. General
	 * 2. dangereuse
	 */
	
}
