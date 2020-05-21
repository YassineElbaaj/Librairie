package com.yassine.models;

import javax.persistence.*;

@Entity
@Table(name= "Author")
public class Author {
	
	@Id @GeneratedValue(Strategy = GenerationType.AUTO)
	@Column(name= "id")
	private int id;
	
	@Column(name= "nom")
	private String nom;
	
	@Column(name= "prenom")
	private String prenom;
	
	public Author() {
		
	}
	public Author(String nom, String prenom) {
		
		this.nom = nom;
		
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
}
