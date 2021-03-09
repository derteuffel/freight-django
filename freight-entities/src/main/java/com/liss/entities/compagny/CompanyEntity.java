package com.liss.entities.compagny;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.liss.embeded.AbstractEntreprise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Company fournit les informations sur les compagnies **/


@Entity(name="Company")
@Table(name="companies")
@Data @AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyEntity extends AbstractEntreprise {
	String companyType;
}
