package com.capgemini.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dzial database table.
 * 
 */
@Entity
@Table(name="dzial")
@NamedQuery(name="Dzial.findAll", query="SELECT d FROM Dzial d")
public class Dzial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_dzial")
	private int idDzial;

	@Column(name="nazwa_dzialu")
	private String nazwaDzialu;

	//bi-directional many-to-one association to Pracownik
	@OneToMany(mappedBy="dzial")
	private List<Pracownik> pracowniks;

	public Dzial() {
	}

	public int getIdDzial() {
		return this.idDzial;
	}

	public void setIdDzial(int idDzial) {
		this.idDzial = idDzial;
	}

	public String getNazwaDzialu() {
		return this.nazwaDzialu;
	}

	public void setNazwaDzialu(String nazwaDzialu) {
		this.nazwaDzialu = nazwaDzialu;
	}

	public List<Pracownik> getPracowniks() {
		return this.pracowniks;
	}

	public void setPracowniks(List<Pracownik> pracowniks) {
		this.pracowniks = pracowniks;
	}

	public Pracownik addPracownik(Pracownik pracownik) {
		getPracowniks().add(pracownik);
		pracownik.setDzial(this);

		return pracownik;
	}

	public Pracownik removePracownik(Pracownik pracownik) {
		getPracowniks().remove(pracownik);
		pracownik.setDzial(null);

		return pracownik;
	}

}