package com.apside.apsgame.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Controller;

@Entity
@Controller
@Table(name = "score")
public class Score {
	
	@Id
	private Long id;
	private Long score;
	private LocalDateTime date;
	
    @ManyToOne
    @JoinColumn(name="user", nullable=false)
    private User user;
    
	public Score() {
	}

	public Score(Long id, Long score, LocalDateTime date, User user) {
		super();
		this.id = id;
		this.score = score;
		this.date = date;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
