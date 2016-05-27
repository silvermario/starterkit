package com.capgemini.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the projekt database table.
 * 
 */
@Entity
@NamedQuery(name="Projekt.findAll", query="SELECT p FROM Projekt p")
public class Projekt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_projekt")
	private int idProjekt;

	@Column(name="czy_wewnetrzny")
	private byte czyWewnetrzny;

	private String nazwa;

	//bi-directional many-to-one association to PracownikHasProjekt
	@OneToMany(mappedBy="projekt")
	private List<PracownikHasProjekt> pracownikHasProjekts;

	public Projekt() {
	}

	public int getIdProjekt() {
		return this.idProjekt;
	}

	public void setIdProjekt(int idProjekt) {
		this.idProjekt = idProjekt;
	}

	public byte getCzyWewnetrzny() {
		return this.czyWewnetrzny;
	}

	public void setCzyWewnetrzny(byte czyWewnetrzny) {
		this.czyWewnetrzny = czyWewnetrzny;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<PracownikHasProjekt> getPracownikHasProjekts() {
		return this.pracownikHasProjekts;
	}

	public void setPracownikHasProjekts(List<PracownikHasProjekt> pracownikHasProjekts) {
		this.pracownikHasProjekts = pracownikHasProjekts;
	}

	public PracownikHasProjekt addPracownikHasProjekt(PracownikHasProjekt pracownikHasProjekt) {
		getPracownikHasProjekts().add(pracownikHasProjekt);
		pracownikHasProjekt.setProjekt(this);

		return pracownikHasProjekt;
	}

	public PracownikHasProjekt removePracownikHasProjekt(PracownikHasProjekt pracownikHasProjekt) {
		getPracownikHasProjekts().remove(pracownikHasProjekt);
		pracownikHasProjekt.setProjekt(null);

		return pracownikHasProjekt;
	}

}