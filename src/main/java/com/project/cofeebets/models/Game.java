package com.project.cofeebets.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Home Team is required!")
    @Size(min=3, max=128, message="Home Team must be between 3 and 128 characters")
    private String homeTeam;
    
    @NotEmpty(message="Away Team is required!")
    @Size(min=3, max=128, message="Away Team must be between 3 and 128 characters")
    private String awayTeam;
    
    @NotEmpty(message="Home Team Score is required!")
    @Size(min=3, max=128, message="Home Team Score must not be null")
    private int homeTeamScore;
    
    @NotEmpty(message="Away Team Score is required!")
    @Size(min=3, max=128, message="Away Team Score must not be null")
    private int awayTeamScore;
    
    @NotEmpty(message="Home Team Odds is required!")
    @Size(min=3, max=128, message="Home Team Odds must not be null")
    private int homeTeamOdds;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gameDay;
    
    private int isClosed = 0;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
    
    private int adminStatus = 0;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="stadium_id")
    private Stadium stadium; 
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "bets", 
        joinColumns = @JoinColumn(name = "game_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Bet> bets;

	public Game() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public int getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public int getHomeTeamOdds() {
		return homeTeamOdds;
	}

	public void setHomeTeamOdds(int homeTeamOdds) {
		this.homeTeamOdds = homeTeamOdds;
	}

	public Date getGameDay() {
		return gameDay;
	}

	public void setGameDay(Date gameDay) {
		this.gameDay = gameDay;
	}

	public int getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(int isClosed) {
		this.isClosed = isClosed;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public int getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(int adminStatus) {
		this.adminStatus = adminStatus;
	}
	
	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;	
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
