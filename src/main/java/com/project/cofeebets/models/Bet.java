package com.project.cofeebets.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name="bets")
public class Bet {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @NotEmpty(message="Amount is required!")
 @Size(min=3, max=128, message="Amount must not be null")
 private int amount;
 
 @NotEmpty(message="Team is required!")
 @Size(min=3, max=128, message="Team must be between 3 and 128 characters")
 private String Team;
 
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="game_id")
 private Game game;
 
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="user_id")
 private User user;
	public Bet() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTeam() {
		return Team;
	}
	public void setTeam(String team) {
		Team = team;
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
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
