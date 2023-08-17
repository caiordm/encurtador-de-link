package com.caio.encurtador.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "url")
public class Url {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "url_original")
	private String urlOriginal;
	
	@Column(name = "url_encurtada")
	private String urlEncurtada;
	
	@Column(name = "hash")
	private String hash;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Long getId() {
		return id;
	}
	
	public String getUrlOriginal() {
		return urlOriginal;
	}
	
	public String getUrlEncurtada() {
		return urlEncurtada;
	}
	
	public String getHash() {
		return hash;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}
	
	public void setUrlEncurtada(String urlEncurtada) {
		this.urlEncurtada = urlEncurtada;
	}
	
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
