package com.liss.entities.offers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.liss.embeded.AbstractEntreprise;
import com.liss.embeded.AbstractTimeStamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name="Transporter")
@Table(name="transporters")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransporterEntity extends AbstractEntreprise {
	
	
}
