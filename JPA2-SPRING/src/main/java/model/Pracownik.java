package main.java.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pracownik database table.
 * 
 */
@Entity
@Table(name = "pracownik")
@NamedQuery(name="Pracownik.findAll", query="SELECT p FROM Pracownik p")
public class Pracownik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pracownik")
	private int idPracownik;

	@Temporal(TemporalType.DATE)
	@Column(name="data_urodzenia")
	private Date dataUrodzenia;

	private String imie;

	private String nazwisko;

	private String pesel;

	//bi-directional many-to-one association to Dzial
	@ManyToOne
	@JoinColumn(name="dzial_iddzial")
	private Dzial dzial;

	//bi-directional many-to-one association to PracownikHasProjekt
	@OneToMany(mappedBy="pracownik")
	private List<PracownikHasProjekt> pracownikHasProjekts;

	public Pracownik() {
	}

	public int getIdPracownik() {
		return this.idPracownik;
	}

	public void setIdPracownik(int idPracownik) {
		this.idPracownik = idPracownik;
	}

	public Date getDataUrodzenia() {
		return this.dataUrodzenia;
	}

	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPesel() {
		return this.pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public Dzial getDzial() {
		return this.dzial;
	}

	public void setDzial(Dzial dzial) {
		this.dzial = dzial;
	}

	public List<PracownikHasProjekt> getPracownikHasProjekts() {
		return this.pracownikHasProjekts;
	}

	public void setPracownikHasProjekts(List<PracownikHasProjekt> pracownikHasProjekts) {
		this.pracownikHasProjekts = pracownikHasProjekts;
	}

	public PracownikHasProjekt addPracownikHasProjekt(PracownikHasProjekt pracownikHasProjekt) {
		getPracownikHasProjekts().add(pracownikHasProjekt);
		pracownikHasProjekt.setPracownik(this);

		return pracownikHasProjekt;
	}

	public PracownikHasProjekt removePracownikHasProjekt(PracownikHasProjekt pracownikHasProjekt) {
		getPracownikHasProjekts().remove(pracownikHasProjekt);
		pracownikHasProjekt.setPracownik(null);

		return pracownikHasProjekt;
	}

}