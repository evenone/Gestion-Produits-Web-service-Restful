package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Categorie implements Serializable{
	public Categorie(String nomCategorie) {
		super();
		NomCategorie = nomCategorie;
	}

	@Id @GeneratedValue
	private Long id;
	private String NomCategorie;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomCategorie() {
		return NomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		NomCategorie = nomCategorie;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

}
