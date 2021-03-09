package com.liss.entities.translate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liss.embeded.AbstractTimeStamp;
import com.liss.entities.management.PermissionEntity;
import com.liss.entities.management.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/** Language va permettre d'assure la gestion des langues **/

@Entity(name = "Language")
@Table(name = "languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguageEntity extends AbstractTimeStamp {

    @Column(name ="code")
    @JsonProperty(value = "code", required = true )
    private String code;

    @Column(name = "description")
    @JsonProperty(value = "description", required = false )
    private String description;

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
    @JsonProperty(value = "translates", required = false)
    @JsonManagedReference
    private List<TranslateStaticEntity> translateStatics = new ArrayList<>();

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
    @JsonProperty(value = "users", required = false)
    @JsonManagedReference
    private List<UserEntity> users = new ArrayList<>();

}
