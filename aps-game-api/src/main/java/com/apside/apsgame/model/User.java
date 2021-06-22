package com.apside.apsgame.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Controller;


@Entity
@Controller
@Table(name = "user")
public class User {
	@Id
	private Long id;
	private String login;
	private String mail;
	private String firstname;
	private String password;
	private LocalDateTime birthdate;
	
//    @OneToMany(mappedBy="user")
//    private Set<Score> scores;

	public User() {
	}

	public User(Long id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public User(Long id, String login, String mail, String firstname, String password, LocalDateTime birthdate) {
		super();
		this.id = id;
		this.login = login;
		this.mail = mail;
		this.firstname = firstname;
		this.password = password;
		this.birthdate = birthdate;
	}
	
	

//	public User(Long id, String login, String mail, String firstname, String password, LocalDateTime birthdate,
//			Set<Score> scores) {
//		super();
//		this.id = id;
//		this.login = login;
//		this.mail = mail;
//		this.firstname = firstname;
//		this.password = password;
//		this.birthdate = birthdate;
//		this.scores = scores;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public LocalDateTime getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDateTime birthdate) {
		this.birthdate = birthdate;
	}

//	public Set<Score> getScores() {
//		return scores;
//	}
//
//	public void setScores(Set<Score> scores) {
//		this.scores = scores;
//	}
}
