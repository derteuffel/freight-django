package com.liss.embeded;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@MappedSuperclass
// cette classe est une abstraite ( Commisionaire et transporteur sont des specialisation)
public abstract class AbstractEntreprise extends AbstractTimeStamp {
	// raison social de l'entreprise
	@Column(name = "name")
	private String name;
	//adresse de l'entreprise
	@Column(name = "address")
	private String address;
	// code postal de l'entreprise
	@Column(name = "postal_code")
	private String postalCode;
	// ville de l'entreprise
	@Column(name = "town")
	private String town;
	// pays de l'entreprise
	@Column(name = "country")
	private String country;
	// tva de l'entreprise
	@Column(name = "vat")
	private String vat;
	// site internet de l'entreprise
	@Column(name = "web_site")
	private String webSite;
	// email de l'entreprise
	@Column(name = "email")
	private String email;
	// telephone de l'entreprise
	@Column(name = "phone")
	private String phone;
	
	// image de l'entreprise
	@Column(name = "image")
	private String image;
	
	// desactiver une entreprise
	@Column(name = "enable")
	private boolean enable = true;
	
	
}
