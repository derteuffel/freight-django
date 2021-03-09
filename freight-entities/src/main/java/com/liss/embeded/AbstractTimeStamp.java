package com.liss.embeded;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@MappedSuperclass
public abstract class AbstractTimeStamp implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id", unique =true)
    private String id;
	
	@Column(name = "created_on")
    private LocalDateTime createdOn;
	
	@Column(name = "created_at")
    private Date createdAt;
 
     
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;
    
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted")
    private Boolean isDeleted;
 
    @PrePersist
    public void prePersist() {
		id = UUID.randomUUID().toString();
		createdOn = LocalDateTime.now();
		createdAt = new Date();
		updatedOn = LocalDateTime.now();
        updatedAt = new Date();
    }
 
    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
        updatedAt = new Date();
    }
    
    
}
