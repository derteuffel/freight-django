package com.liss.entities.management;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liss.embeded.AbstractConstanteEntity;

import com.liss.embeded.AbstractTimeStamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/*** Role permet d'avoir les roles de chaque utilisateur ***/

@Entity(name="Role")
@Table(name="roles")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleEntity extends AbstractTimeStamp {

    @Column(name="code", unique = true)
    @JsonProperty(value = "code", required = true )
    private String code;

    @Column(name="description")
    @JsonProperty(value = "description", required = false )
    private String description;



    @ManyToMany(cascade= CascadeType.ALL)//(fetch=FetchType.EAGER)
    @JoinTable(name="roles_permissions",
            joinColumns={@JoinColumn(name="role_id")},
            inverseJoinColumns={@JoinColumn(name="permission_id")})
    @JsonProperty(value = "permissions", required = false )
    private List<PermissionEntity> permissions = new ArrayList<>();

}
