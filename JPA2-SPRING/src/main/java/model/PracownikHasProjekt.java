package main.java.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


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

	@Column(name="data_rozpoczecia")
	private Timestamp dataRozpoczecia;

	@Column(name="data_zakonczenia")
	private Timestamp dataZakonczenia;

	private String rola;

	@Column(name="stawka_dzienna")
	private BigDecimal stawkaDzienna;

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

	public Timestamp getDataRozpoczecia() {
		return this.dataRozpoczecia;
	}

	public void setDataRozpoczecia(Timestamp dataRozpoczecia) {
		this.dataRozpoczecia = dataRozpoczecia;
	}

	public Timestamp getDataZakonczenia() {
		return this.dataZakonczenia;
	}

	public void setDataZakonczenia(Timestamp dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}

	public String getRola() {
		return this.rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	public BigDecimal getStawkaDzienna() {
		return this.stawkaDzienna;
	}

	public void setStawkaDzienna(BigDecimal stawkaDzienna) {
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