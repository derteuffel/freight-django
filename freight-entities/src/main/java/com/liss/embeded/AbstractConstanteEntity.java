package com.liss.embeded;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@MappedSuperclass
public abstract class AbstractConstanteEntity implements Serializable{
	
	@Id
	@Column(name="id", unique =true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id ;
	
	@Column(name = "code", unique=true)
	private String code ;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "enable")
	private boolean enable = true;

	
	
}
