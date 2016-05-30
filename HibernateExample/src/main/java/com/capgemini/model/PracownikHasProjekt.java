package com.capgemini.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pracownik_has_projekt database table.
 * 
 */
@Entity
@Table(name="pracownik_has_projekt")
@NamedQuery(name="PracownikHasProjekt.findAll", query="SELECT p FROM PracownikHasProjekt p")
public class PracownikHasProjekt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pracownik_do_projektu")
	private int idPracownikDoProjektu;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_rozpoczecia")
	private Date dataRozpoczecia;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_zakonczenia")
	private Date dataZakonczenia;

	private String rola;

	@Column(name="stawka_dzienna")
	private Double stawkaDzienna;

	//bi-directional many-to-one association to Pracownik
	@ManyToOne
	private Pracownik pracownik;

	//bi-directional many-to-one association to Projekt
	@ManyToOne
	private Projekt projekt;

	public PracownikHasProjekt() {
	}

	public int getIdPracownikDoProjektu() {
		return this.idPracownikDoProjektu;
	}

	public void setIdPracownikDoProjektu(int idPracownikDoProjektu) {
		this.idPracownikDoProjektu = idPracownikDoProjektu;
	}

	public Date getDataRozpoczecia() {
		return this.dataRozpoczecia;
	}

	public void setDataRozpoczecia(Date dataRozpoczecia) {
		this.dataRozpoczecia = dataRozpoczecia;
	}

	public Date getDataZakonczenia() {
		return this.dataZakonczenia;
	}

	public void setDataZakonczenia(Date dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}

	public String getRola() {
		return this.rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	public Double getStawkaDzienna() {
		return this.stawkaDzienna;
	}

	public void setStawkaDzienna(Double stawkaDzienna) {
		this.stawkaDzienna = stawkaDzienna;
	}

	public Pracownik getPracownik() {
		return this.pracownik;
	}

	public void setPracownik(Pracownik pracownik) {
		this.pracownik = pracownik;
	}

	public Projekt getProjekt() {
		return this.projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}

}