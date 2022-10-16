package com.project.cofeebets.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="stadiums")
public class Stadium {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Address is required!")
    @Size(min=3, max=128, message="Address must be between 3 and 128 characters")
    private String address;
    
    @NotEmpty(message="Name is required!")
    @Size(min=8, max=128, message="Name must be between 8 and 128 characters")
    private String name;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    
    
    @OneToMany(mappedBy="stadium", fetch = FetchType.LAZY)
    private List<Game> games;

	public Stadium() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Game> getGmaes() {
		return games;
	}

	public void setGmaes(List<Game> gmaes) {
		this.games = gmaes;
	}

	 @PrePersist 
	    protected void onCreate() {
	    	this.createdAt = new Date();
	}
	    
	 @PreUpdate
	    protected void onUpdate() {
	       this.updatedAt = new Date();
	}
}
