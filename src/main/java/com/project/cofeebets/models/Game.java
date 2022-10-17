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
    
    private Integer homeTeamScore;
    
    private Integer awayTeamScore;
    
    private Integer homeTeamOdds;
    
    private Integer awayTeamOdds;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gameDay;
    
    private int isClosed = 0;
    
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

	public Integer getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(Integer homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public Integer getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(Integer awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public Integer getHomeTeamOdds() {
		return homeTeamOdds;
	}

	public void setHomeTeamOdds(Integer homeTeamOdds) {
		this.homeTeamOdds = homeTeamOdds;
	}
	
	
	public Integer getAwayTeamOdds() {
		return awayTeamOdds;
	}

	public void setAwayTeamOdds(Integer awayTeamOdds) {
		this.awayTeamOdds = awayTeamOdds;
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
