package com.liss.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.liss.embeded.AbstractTimeStamp;

import com.liss.entities.management.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Message")
@Table(name="message")
public class MessageEntity extends AbstractTimeStamp{

	@Column(name = "code", unique = true)
	private String code;
	
	
	@Column(name = "attached_files") // liste des piece jointe recu lors de la conversation separateur(;)
	private String attached_files;
	
	@Column(name = "body", length = 5000)
	private String body;
	
	/*** Mise en place des relations avec les autres tables **/	
	
	// Mapping manyToOne
	@ManyToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="sender_id", nullable = true)
	UserEntity sender;
	
	@ManyToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="receiver_id", nullable = true)
	UserEntity receiver;
	
}
