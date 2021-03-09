package com.liss.entities.management;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liss.embeded.AbstractTimeStamp;

import com.liss.entities.compagny.CompanyEntity;
import com.liss.entities.translate.LanguageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/***  User permet d'avoir les informations sur les utilisateurs  ***/

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="User")
@Table(name="users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntity extends AbstractTimeStamp {

	@Column(name ="name")
	@JsonProperty(value = "name", required = true )
	private String name;
	
	@Column(name ="firstname")
	@JsonProperty(value = "firstname", required = false )
	private String firstName;
	
	@Column(name ="email", unique = true)
	@JsonProperty(value = "email", required = true )
	private String email;

	@Column(name ="fax")
	@JsonProperty(value = "fax", required = false )
	private String fax;
	
	@Column(name ="login", unique=true)
	@JsonProperty(value = "login", required = true )
	private String login;
	
	@Column(name ="password")
	@JsonProperty(value = "password", required = true )
	private String password;

	@ManyToOne
	@JoinColumn(name="role_id", referencedColumnName="id", nullable = true)
	@JsonProperty(value = "role", required = false )
	RoleEntity role;
	
	//@author Jaudrix
	@ManyToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="company_id", referencedColumnName="id", nullable = true)
	@JsonProperty(value = "company", required = false )
	CompanyEntity company;

	@ManyToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="language_id", referencedColumnName="id", nullable = true)
	@JsonProperty(value = "language", required = false)
	private LanguageEntity language;
	
	//@author Jaudrix
	@ManyToMany(cascade=CascadeType.ALL)//(fetch=FetchType.EAGER)
	@JoinTable(name="access_permissions",
			joinColumns={@JoinColumn(name="user_id")},
			inverseJoinColumns={@JoinColumn(name="permission_id")})
	@JsonProperty(value = "permissions", required = false )
	private List<PermissionEntity> permissions = new ArrayList<>();
	
	
	
	
	
	
}
